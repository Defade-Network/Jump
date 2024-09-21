package net.defade.jump;

import net.defade.jump.map.JumpInstance;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;

public class Main {
    public static void main(String[] args) {
        MinecraftServer minecraftServer = MinecraftServer.init();

        JumpInstance jumpInstance = new JumpInstance();

        MinecraftServer.getGlobalEventHandler().addListener(AsyncPlayerConfigurationEvent.class, event -> {
            event.setSpawningInstance(jumpInstance);
            event.getPlayer().setRespawnPoint(JumpInstance.SPAWN_POSITION);
        });

        minecraftServer.start();
    }
}