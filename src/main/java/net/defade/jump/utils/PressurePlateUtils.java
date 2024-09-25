package net.defade.jump.utils;

import net.defade.jump.event.PressurePlateEvent;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.event.EventDispatcher;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerMoveEvent;
import net.minestom.server.instance.block.Block;
import net.minestom.server.tag.Tag;
import java.util.ArrayList;
import java.util.List;

public class PressurePlateUtils {
    private static final Tag<List<Pos>> ACTIVATED_PRESSURE_PLATES = Tag.Transient("activated_pressure_plates");

    public static void registerPressurePlateEvent() {
        MinecraftServer.getGlobalEventHandler()
                .addListener(AsyncPlayerConfigurationEvent.class, event -> {
                    event.getPlayer().setTag(ACTIVATED_PRESSURE_PLATES, new ArrayList<>(4));
                })
                .addListener(PlayerMoveEvent.class, playerMoveEvent -> {
                    if (playerMoveEvent.getNewPosition().distanceSquared(playerMoveEvent.getPlayer().getPosition()) == 0) {
                        return;
                    }

                    Pos middle = playerMoveEvent.getNewPosition();

                    Pos[] corners = {
                            middle.add(0.3 - 0.0625, 0, 0.3 - 0.0625),
                            middle.add(0.3 - 0.0625, 0, -0.3 + 0.0625),
                            middle.add(-0.3 + 0.0625, 0, 0.3 - 0.0625),
                            middle.add(-0.3 + 0.0625, 0, -0.3 + 0.0625)
                    };

                    List<Pos> activatedPressurePlates = playerMoveEvent.getPlayer().getTag(ACTIVATED_PRESSURE_PLATES);
                    List<Pos> toRemove = new ArrayList<>(activatedPressurePlates);

                    for (Pos corner : corners) {
                        Pos blockPos = new Pos(corner.blockX(), corner.blockY(), corner.blockZ());
                        Block block = playerMoveEvent.getInstance().getBlock(blockPos);
                        if (block.name().endsWith("pressure_plate") && playerMoveEvent.getNewPosition().y() < middle.blockY() + 0.0625) {
                            if (!activatedPressurePlates.contains(blockPos)) {
                                activatedPressurePlates.add(blockPos);
                                EventDispatcher.call(new PressurePlateEvent(playerMoveEvent.getPlayer(), block, blockPos, true));
                            } else {
                                toRemove.remove(blockPos);
                            }
                        }
                    }

                    // Remove pressure plates that are no longer activated
                    for (Pos pos : toRemove) {
                        activatedPressurePlates.remove(pos);
                        EventDispatcher.call(new PressurePlateEvent(playerMoveEvent.getPlayer(), playerMoveEvent.getInstance().getBlock(pos), pos, false));
                    }
                });
    }
}
