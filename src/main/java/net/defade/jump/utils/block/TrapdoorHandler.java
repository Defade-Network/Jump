package net.defade.jump.utils.block;

import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.BlockVec;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerBlockInteractEvent;
import net.minestom.server.event.player.PlayerChunkUnloadEvent;
import net.minestom.server.network.packet.server.play.BlockChangePacket;
import net.minestom.server.tag.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrapdoorHandler {
    private static final Tag<Map<BlockVec, Boolean>> TRAPDOOR_STATES = Tag.Transient("trapdoor_states"); // Trapdoor states for each player

    public static void registerEvents() {
        MinecraftServer.getGlobalEventHandler()
                .addListener(AsyncPlayerConfigurationEvent.class, event -> {
                    event.getPlayer().setTag(TRAPDOOR_STATES, new HashMap<>());
                })
                .addListener(PlayerBlockInteractEvent.class, event -> {
                    Player player = event.getPlayer();

                    if (event.getBlock().name().endsWith("trapdoor")) {
                        boolean newOpenState;
                        if (player.getTag(TRAPDOOR_STATES).containsKey(event.getBlockPosition())) {
                            newOpenState = !player.getTag(TRAPDOOR_STATES).get(event.getBlockPosition());
                        } else {
                            newOpenState = !Boolean.parseBoolean(event.getBlock().getProperty("open"));
                        }

                        player.sendPacket(new BlockChangePacket(event.getBlockPosition(),
                                event.getBlock().withProperty("open", String.valueOf(newOpenState)).stateId()));
                        player.getTag(TRAPDOOR_STATES).put(event.getBlockPosition(), newOpenState);
                    }
                })
                .addListener(PlayerChunkUnloadEvent.class, event -> {
                    Player player = event.getPlayer();

                    Map<BlockVec, Boolean> trapdoorStates = player.getTag(TRAPDOOR_STATES);
                    List<BlockVec> toRemove = new ArrayList<>(trapdoorStates.size());
                    for (BlockVec blockVec : trapdoorStates.keySet()) {
                        if (blockVec.chunkX() == event.getChunkX() && blockVec.chunkZ() == event.getChunkZ()) {
                            toRemove.add(blockVec);
                        }
                    }

                    toRemove.forEach(trapdoorStates::remove);
                });
    }
}
