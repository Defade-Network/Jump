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
}
