package net.defade.jump.data;

import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.tag.Tag;

public class PlayerStatManager {
    private static final Tag<PlayerStat> PLAYER_STAT_TAG = Tag.Transient("player_stat");

    public static void registerEvents() {
        MinecraftServer.getGlobalEventHandler().addListener(AsyncPlayerConfigurationEvent.class, event -> {
            event.getPlayer().setTag(PLAYER_STAT_TAG, new PlayerStat(event.getPlayer()));
        });
    }

    public static PlayerStat getPlayerStat(Player player) {
        return player.getTag(PLAYER_STAT_TAG);
    }
}
