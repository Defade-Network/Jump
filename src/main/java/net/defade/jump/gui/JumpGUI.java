package net.defade.jump.gui;

import net.defade.jump.jumps.Difficulties;
import net.defade.jump.jumps.Jumps;
import net.defade.jump.utils.Items;
import net.kyori.adventure.text.format.TextColor;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.item.ItemComponent;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

public class JumpGUI extends Inventory {
    private static final int PREVIOUS_BUTTON_SLOT = 18;
    private static final int NEXT_BUTTON_SLOT = 26;

    public JumpGUI(Difficulties difficulties) {
        this(difficulties, 0);
    }

    public JumpGUI(Difficulties difficulties, int page) {
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
                setItemStack(jumpItemSlot, generateJumpItem(jump));

                addInventoryCondition((player, slot, clickType, inventoryConditionResult) -> {
                    if (slot == jumpItemSlot) {
                        player.teleport(jump.getMiddleStartPlate().withYaw(jump.getStartYaw()));
                        player.closeInventory();
                    }
                });
            }
        }

        final boolean hasNextPage = itemSlot == NEXT_BUTTON_SLOT;

        addInventoryCondition((player, slot, clickType, inventoryConditionResult) -> {
            inventoryConditionResult.setCancel(true);

            if (slot == PREVIOUS_BUTTON_SLOT && page > 0) {
                player.openInventory(new JumpGUI(difficulties, page - 1));
            } else if (slot == NEXT_BUTTON_SLOT && hasNextPage) {
                player.openInventory(new JumpGUI(difficulties, page + 1));
            }
        });
    }

    private ItemStack generateJumpItem(Jumps jump) {
        // TODO: Add description about whether the jump is completed or not, the time it took to complete it, etc.
        return ItemStack.of(Material.RED_STAINED_GLASS)
                .with(ItemComponent.ITEM_NAME, jump.getName());
    }
}
