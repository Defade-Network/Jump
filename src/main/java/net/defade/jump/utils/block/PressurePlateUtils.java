package net.defade.jump.utils.block;

import net.defade.jump.event.PressurePlateEvent;
import net.kyori.adventure.sound.Sound;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.BlockVec;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.EventDispatcher;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerMoveEvent;
import net.minestom.server.instance.block.Block;
import net.minestom.server.network.packet.server.play.BlockChangePacket;
import net.minestom.server.sound.SoundEvent;
import net.minestom.server.tag.Tag;
import java.util.ArrayList;
import java.util.List;

public class PressurePlateUtils {
    private static final Tag<List<BlockVec>> ACTIVATED_PRESSURE_PLATES = Tag.Transient("activated_pressure_plates");

    public static void registerPressurePlateEvent() {
        MinecraftServer.getGlobalEventHandler()
                .addListener(AsyncPlayerConfigurationEvent.class, event -> {
                    event.getPlayer().setTag(ACTIVATED_PRESSURE_PLATES, new ArrayList<>(4));
                })
                .addListener(PlayerMoveEvent.class, playerMoveEvent -> {
                    Player player = playerMoveEvent.getPlayer();
                    if (playerMoveEvent.getNewPosition().distanceSquared(player.getPosition()) == 0) {
                        return;
                    }

                    Pos middle = playerMoveEvent.getNewPosition();

                    Pos[] corners = {
                            middle.add(0.3 - 0.0625, 0, 0.3 - 0.0625),
                            middle.add(0.3 - 0.0625, 0, -0.3 + 0.0625),
                            middle.add(-0.3 + 0.0625, 0, 0.3 - 0.0625),
                            middle.add(-0.3 + 0.0625, 0, -0.3 + 0.0625)
                    };

                    List<BlockVec> activatedPressurePlates = player.getTag(ACTIVATED_PRESSURE_PLATES);
                    List<BlockVec> toRemove = new ArrayList<>(activatedPressurePlates);

                    for (Pos corner : corners) {
                        BlockVec blockPos = new BlockVec(corner);
                        Block block = playerMoveEvent.getInstance().getBlock(blockPos);
                        if (block.name().endsWith("pressure_plate") && playerMoveEvent.getNewPosition().y() < middle.blockY() + 0.0625) {
                            if (!activatedPressurePlates.contains(blockPos)) {
                                activatedPressurePlates.add(blockPos);
                                EventDispatcher.call(new PressurePlateEvent(player, block, blockPos, true));

                                player.sendPacket(new BlockChangePacket(blockPos, block.withProperty("power", "15").stateId()));
                                player.playSound(Sound.sound().type(SoundEvent.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON).pitch(1).volume(1).build());
                            } else {
                                toRemove.remove(blockPos);
                            }
                        }
                    }

                    // Remove pressure plates that are no longer activated
                    for (BlockVec pos : toRemove) {
                        activatedPressurePlates.remove(pos);
                        EventDispatcher.call(new PressurePlateEvent(player, playerMoveEvent.getInstance().getBlock(pos), pos, false));

                        player.sendPacket(new BlockChangePacket(pos, playerMoveEvent.getInstance().getBlock(pos).withProperty("power", "0").stateId()));
                        player.playSound(Sound.sound().type(SoundEvent.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF).pitch(1).volume(1).build());
                    }
                });
    }
}
