package net.defade.jump.map;

import net.defade.minestom.amethyst.AmethystLoader;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.event.player.PlayerBlockBreakEvent;
import net.minestom.server.event.player.PlayerBlockPlaceEvent;
import net.minestom.server.event.player.PlayerMoveEvent;
import net.minestom.server.event.player.PlayerSpawnEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.world.DimensionType;

import java.util.UUID;

public class JumpInstance extends InstanceContainer {
    public static final Pos SPAWN_POSITION = new Pos(7.5, 5, 2.5);

    public JumpInstance() {
        super(UUID.randomUUID(), DimensionType.OVERWORLD);
        MinecraftServer.getInstanceManager().registerInstance(this);

        AmethystLoader amethystLoader = new AmethystLoader(this, new JumpMapSource());
        setChunkLoader(amethystLoader);

        registerPlayerRestrictions();
    }

    private void registerPlayerRestrictions() {
        MinecraftServer.getGlobalEventHandler()
                .addListener(PlayerSpawnEvent.class, event -> {
                    event.getPlayer().setGameMode(GameMode.ADVENTURE);
                })
                .addListener(PlayerMoveEvent.class, event -> {
                    if (event.getPlayer().getPosition().y() < -10) {
                        event.getPlayer().teleport(SPAWN_POSITION);
                    }
                })
                .addListener(PlayerBlockPlaceEvent.class, event -> {
                    event.setCancelled(true);
                })
                .addListener(PlayerBlockBreakEvent.class, event -> {
                    event.setCancelled(true);
                });
    }
}
