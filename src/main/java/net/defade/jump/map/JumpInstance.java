package net.defade.jump.map;

import net.defade.jump.event.PressurePlateEvent;
import net.defade.jump.jumps.JumpTracker;
import net.defade.jump.jumps.Jumps;
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
        registerJumpStarts();
    }

    private void registerPlayerRestrictions() {
        MinecraftServer.getGlobalEventHandler()
                .addListener(PlayerSpawnEvent.class, event -> {
                    event.getPlayer().setGameMode(GameMode.ADVENTURE);
                })
                .addListener(PlayerMoveEvent.class, event -> {
                    if (event.getPlayer().getPosition().y() < -10) {
                        Pos position;
                        if (JumpTracker.getCurrentCheckpoint(event.getPlayer()) != null) {
                            position = JumpTracker.getCurrentCheckpoint(event.getPlayer());
                        } else if (JumpTracker.getPlayerJump(event.getPlayer()) != null) {
                            Jumps jump = JumpTracker.getPlayerJump(event.getPlayer());
                            position = jump.getMiddleStartPlate().withYaw(jump.getStartYaw());
                        } else {
                            position = SPAWN_POSITION;
                        }

                        event.getPlayer().teleport(position);
                    }
                })
                .addListener(PlayerBlockPlaceEvent.class, event -> {
                    event.setCancelled(true);
                })
                .addListener(PlayerBlockBreakEvent.class, event -> {
                    event.setCancelled(true);
                });
    }

    private void registerJumpStarts() {
        MinecraftServer.getGlobalEventHandler().addListener(PressurePlateEvent.class, event -> {
            if (event.isPressed()) {
                for (Jumps jump : Jumps.values()) {
                    if (jump.getStartPlates().contains(event.getPos())) {
                        JumpTracker.startJumpForPlayer(event.getPlayer(), jump);
                    }
                }
            }
        });
    }
}
