package net.defade.jump.gui;

import net.defade.jump.data.PlayerStat;
import net.defade.jump.data.PlayerStatManager;
import net.defade.jump.jumps.Difficulties;
import net.defade.jump.jumps.Jumps;
import net.defade.jump.utils.Items;
import net.defade.jump.utils.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.minestom.server.entity.Player;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.item.ItemComponent;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

import java.util.ArrayList;
import java.util.List;

public class JumpGUI extends Inventory {
    private static final MiniMessage MM = MiniMessage.miniMessage();

    private static final int PREVIOUS_BUTTON_SLOT = 18;
    private static final int NEXT_BUTTON_SLOT = 26;

    public JumpGUI(Player player, Difficulties difficulties) {
        this(player, difficulties, 0);
    }

    public JumpGUI(Player player, Difficulties difficulties, int page) {
        super(InventoryType.CHEST_3_ROW, difficulties.getName().color(TextColor.color(63, 63, 63)));

        for (int i = 0; i < 27; i++) {
            setItemStack(i, ItemStack.of(Material.GRAY_STAINED_GLASS_PANE)
                    .with(ItemComponent.HIDE_TOOLTIP));
        }
        setItemStack(PREVIOUS_BUTTON_SLOT, Items.PREVIOUS_BUTTON);
        setItemStack(NEXT_BUTTON_SLOT, Items.NEXT_BUTTON);

        final int itemsToSkip = page * 25; // The inventory has 27 slots, but 2 are used for the previous and next buttons
        int skippedItems = 0;

        int itemSlot = -1;
        for (Jumps jump : Jumps.values()) {
            if (jump.getDifficulty() == difficulties) {
                if (skippedItems < itemsToSkip) {
                    skippedItems++;
                    continue;
                }

                itemSlot++;
                if (itemSlot == PREVIOUS_BUTTON_SLOT) {
                    itemSlot++;
                } else if (itemSlot == NEXT_BUTTON_SLOT) {
                    break;
                }

                final int jumpItemSlot = itemSlot;
                setItemStack(jumpItemSlot, generateJumpItem(jump, player));

                addInventoryCondition((unusedPlayer, slot, clickType, inventoryConditionResult) -> {
                    if (slot == jumpItemSlot) {
                        player.teleport(jump.getMiddleStartPlate().withYaw(jump.getStartYaw()));
                        player.closeInventory();
                    }
                });
            }
        }

        final boolean hasNextPage = itemSlot == NEXT_BUTTON_SLOT;

        addInventoryCondition((unusedPlayer, slot, clickType, inventoryConditionResult) -> {
            inventoryConditionResult.setCancel(true);

            if (slot == PREVIOUS_BUTTON_SLOT && page > 0) {
                player.openInventory(new JumpGUI(player, difficulties, page - 1));
            } else if (slot == NEXT_BUTTON_SLOT && hasNextPage) {
                player.openInventory(new JumpGUI(player, difficulties, page + 1));
            }
        });
    }

    private ItemStack generateJumpItem(Jumps jump, Player player) {
        PlayerStat playerStat = PlayerStatManager.getPlayerStat(player);

        Material jumpMaterial;
        List<Component> lore = new ArrayList<>();

        if(playerStat.hasRealizedJump(jump)) {
            if(playerStat.getJumpTime(jump) <= jump.getTimeForReward()) { // If the player did the challenge
                jumpMaterial = Material.LIME_STAINED_GLASS_PANE;

                lore.add(MM.deserialize("<color:#49d338><italic:false>✔ Terminé!"));
                lore.add(Component.text(""));
                lore.add(MM.deserialize("<gray><italic:false>» <color:#00be00>Personal Best: <white>" + Utils.convertToReadableTime(playerStat.getJumpTime(jump))));
            } else {
                jumpMaterial = Material.ORANGE_STAINED_GLASS_PANE;

                lore.add(MM.deserialize("<color:#bed338><italic:false>✔ Terminé (Sans Challenge)"));
                lore.add(Component.text(""));
                lore.add(MM.deserialize("<gray><italic:false>» <color:#fa9600>◆ Challenge Time: <white>" + Utils.convertToReadableTime(jump.getTimeForReward())));
                lore.add(MM.deserialize("<gray><italic:false>» <color:#ffec11>⛃ Coins: <white>" + jump.getCrystalReward()));
                lore.add(MM.deserialize("<gray><italic:false>» <color:#14aeff>❂ Endermites: <white>" + jump.getEndermiteReward()));
                lore.add(Component.text(""));
                lore.add(MM.deserialize("<gray><italic:false>» <color:#00be00>Personal Best: <white>" + Utils.convertToReadableTime(playerStat.getJumpTime(jump))));
            }
        } else {
            jumpMaterial = Material.RED_STAINED_GLASS_PANE;

            lore.add(MM.deserialize("<color:#ff1919><italic:false>❌ Non fait"));
            lore.add(Component.text(""));
            lore.add(MM.deserialize("<gray><italic:false>» <color:#fa9600>◆ Challenge Time: <white>" + Utils.convertToReadableTime(jump.getTimeForReward())));
            lore.add(MM.deserialize("<gray><italic:false>» <color:#ffec11>⛃ Coins: <white>" + jump.getCrystalReward()));
            lore.add(MM.deserialize("<gray><italic:false>» <color:#14aeff>❂ Endermites: <white>" + jump.getEndermiteReward()));
            lore.add(Component.text(""));
            lore.add(MM.deserialize("<gray><italic:false>» <color:#00be00>Personal Best: <white>Aucun"));
          }

        return ItemStack.of(jumpMaterial)
                .with(ItemComponent.ITEM_NAME, jump.getName())
                .with(ItemComponent.LORE, lore);
    }
}
