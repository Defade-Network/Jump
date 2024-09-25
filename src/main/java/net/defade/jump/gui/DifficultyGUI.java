package net.defade.jump.gui;

import net.defade.jump.jumps.Difficulties;
import net.defade.jump.utils.Items;
import net.kyori.adventure.text.Component;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;

public class DifficultyGUI extends Inventory {
    public DifficultyGUI() {
        super(InventoryType.CHEST_3_ROW, Component.text("Difficultés"));

        for (int i = 0; i < 27; i++) {
            setItemStack(i, Items.INVENTORY_FILLER);
        }

        setItemStack(11, Items.DIFFICULTY_ITEM.apply(Difficulties.VERY_EASY));
        setItemStack(12, Items.DIFFICULTY_ITEM.apply(Difficulties.EASY));
        setItemStack(13, Items.DIFFICULTY_ITEM.apply(Difficulties.MEDIUM));
        setItemStack(14, Items.DIFFICULTY_ITEM.apply(Difficulties.HARD));
        setItemStack(15, Items.DIFFICULTY_ITEM.apply(Difficulties.EXTREME));

        addInventoryCondition((player, slot, clickType, inventoryConditionResult) -> {
            inventoryConditionResult.setCancel(true);

            if (slot >= 11 && slot <= 15) {
                player.openInventory(new JumpGUI(player, Difficulties.values()[slot - 11]));
            }
        });
    }
}
