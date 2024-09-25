package net.defade.jump.utils;

import net.defade.jump.jumps.Difficulties;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.minestom.server.item.ItemComponent;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

import java.util.function.Function;

public class Items {
    private static final MiniMessage MM = MiniMessage.miniMessage();

    public static final ItemStack MENU_ITEM = ItemStack.of(Material.FEATHER)
            .with(ItemComponent.ITEM_NAME, MM.deserialize("<dark_green>Menu"));

    public static final ItemStack INVENTORY_FILLER = ItemStack.of(Material.GRAY_STAINED_GLASS_PANE)
            .with(ItemComponent.HIDE_TOOLTIP);

    public static final Function<Difficulties, ItemStack> DIFFICULTY_ITEM = difficulty -> ItemStack.of(difficulty.getItem())
            .with(ItemComponent.ITEM_NAME, difficulty.getName());

    public static final ItemStack PREVIOUS_BUTTON = ItemStack.of(Material.ARROW)
            .with(ItemComponent.ITEM_NAME, MM.deserialize("<dark_green>Précédent"));

    public static final ItemStack NEXT_BUTTON = ItemStack.of(Material.ARROW)
            .with(ItemComponent.ITEM_NAME, MM.deserialize("<dark_green>Suivant"));

    public static final ItemStack HUB = ItemStack.of(Material.DARK_OAK_DOOR)
            .with(ItemComponent.ITEM_NAME, MM.deserialize("<gray>» <color:#e82c2c>Hub"));

    public static final ItemStack QUIT_JUMP = ItemStack.of(Material.BARRIER)
            .with(ItemComponent.ITEM_NAME, MM.deserialize("<gray>» <color:#e82c2c>Quitter le jump"));

    public static final ItemStack PLAYERS_SHOWN = ItemStack.of(Material.LIME_DYE)
            .with(ItemComponent.ITEM_NAME, MM.deserialize("<gray>» <color:#23cc21>Joueurs Visibles"));

    public static final ItemStack PLAYERS_HIDDEN = ItemStack.of(Material.RED_DYE)
            .with(ItemComponent.ITEM_NAME, MM.deserialize("<gray>» <color:#5a5a5a>Joueurs Cachés"));
}
