package net.defade.jump;

import net.defade.jump.gui.DifficultyGUI;
import net.defade.jump.jumps.JumpTracker;
import net.defade.jump.map.JumpInstance;
import net.defade.jump.utils.Items;
import net.defade.jump.utils.PressurePlateUtils;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.item.ItemDropEvent;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerSpawnEvent;
import net.minestom.server.event.player.PlayerUseItemEvent;

public class Main {
    public static void main(String[] args) {
        MinecraftServer minecraftServer = MinecraftServer.init();

        PressurePlateUtils.registerPressurePlateEvent();
        JumpTracker.registerEvents();

        JumpInstance jumpInstance = new JumpInstance();

        MinecraftServer.getGlobalEventHandler().addListener(AsyncPlayerConfigurationEvent.class, event -> {
            event.setSpawningInstance(jumpInstance);
            event.getPlayer().setRespawnPoint(JumpInstance.SPAWN_POSITION);
        });

        MinecraftServer.getGlobalEventHandler()
                .addListener(PlayerSpawnEvent.class, event -> event.getPlayer().getInventory().setItemStack(0, Items.MENU_ITEM))
                .addListener(ItemDropEvent.class, event -> event.setCancelled(true))
                .addListener(PlayerUseItemEvent.class, event -> {
                    if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(Items.MENU_ITEM)) {
                        event.getPlayer().openInventory(new DifficultyGUI());
                    }
                });

        minecraftServer.start();
    }
}