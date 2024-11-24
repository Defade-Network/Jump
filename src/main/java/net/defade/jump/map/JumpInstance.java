package net.defade.jump.map;

import net.defade.jump.event.PressurePlateEvent;
import net.defade.jump.jumps.JumpTracker;
import net.defade.jump.jumps.Jumps;
import net.defade.minestom.amethyst.AmethystLoader;
import net.kyori.adventure.sound.Sound;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerBlockBreakEvent;
import net.minestom.server.event.player.PlayerBlockPlaceEvent;
import net.minestom.server.event.player.PlayerMoveEvent;
import net.minestom.server.event.player.PlayerSpawnEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.block.Block;
import net.minestom.server.sound.SoundEvent;
import net.minestom.server.tag.Tag;
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
        registerBoostPressurePlates();
    }

    private void registerPlayerRestrictions() {
        MinecraftServer.getGlobalEventHandler()
                .addListener(PlayerSpawnEvent.class, event -> {
                    event.getPlayer().setGameMode(GameMode.ADVENTURE);
                })
                .addListener(PlayerMoveEvent.class, event -> {
                    if (event.getPlayer().getPosition().y() < -2) {
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
                        event.getPlayer().playSound(Sound.sound().type(SoundEvent.ENTITY_ENDERMAN_TELEPORT).pitch(1).volume(0.6F).build());
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
                        event.getPlayer().playSound(Sound.sound().type(SoundEvent.BLOCK_AMETHYST_BLOCK_RESONATE).pitch(1).volume(1).build());
                        break;
                    }
                }
            }
        });
    }

    private void registerBoostPressurePlates() {
        MinecraftServer.getGlobalEventHandler().addListener(PressurePlateEvent.class, event -> {
            Player player = event.getPlayer();

            if (player.hasTag(Tag.Long("player_jump_start_time"))) return;

            if (event.isPressed() && event.getPressurePlate().equals(Block.LIGHT_WEIGHTED_PRESSURE_PLATE)) {
                player.setVelocity(player.getPosition().direction().mul(25));
                player.playSound(Sound.sound().type(SoundEvent.BLOCK_PISTON_CONTRACT).pitch(1).volume(1).build());
            }
        });
    }
}
