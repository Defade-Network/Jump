package net.defade.jump.jumps;

import net.defade.jump.event.PressurePlateEvent;
import net.defade.jump.map.JumpInstance;
import net.defade.jump.utils.Utils;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerMoveEvent;
import net.minestom.server.event.player.PlayerTickEvent;
import net.minestom.server.instance.block.Block;
import net.minestom.server.tag.Tag;

public class JumpTracker {
    private static final MiniMessage MM = MiniMessage.miniMessage();

    private static final Tag<Jumps> PLAYER_JUMP = Tag.Transient("player_jump");
    private static final Tag<Long> PLAYER_JUMP_START_TIME = Tag.Long("player_jump_start_time");

    private static final Block CHECKPOINT_BLOCK = Block.POLISHED_BLACKSTONE_PRESSURE_PLATE;
    private static final Tag<Pos> CHECKPOINT_POS = Tag.Transient("checkpoint_pos");

    private static final Block FINISH_BLOCK = Block.DIAMOND_BLOCK;

    public static void startJumpForPlayer(Player player, Jumps jump) {
        finishJump(player, false);
        player.setTag(PLAYER_JUMP, jump);
        player.setTag(PLAYER_JUMP_START_TIME, System.currentTimeMillis());
    }

    public static void registerEvents() {
        MinecraftServer.getGlobalEventHandler()
                .addListener(PressurePlateEvent.class, event -> {
                    Player player = event.getPlayer();
                    Jumps jump = getPlayerJump(player);
                    if (jump == null) {
                        return;
                    }

                    if (event.isPressed() && event.getPressurePlate().compare(CHECKPOINT_BLOCK)) {
                        player.setTag(CHECKPOINT_POS, player.getPosition());
                    }
                })
                .addListener(PlayerMoveEvent.class, event -> {
                    Player player = event.getPlayer();
                    Jumps jump = getPlayerJump(player);
                    if (jump == null) {
                        return;
                    }

                    if (event.getNewPosition().distanceSquared(player.getPosition()) == 0) {
                        return;
                    }

                    Pos blockPosUnderPlayer = new Pos(player.getPosition().blockX(), Math.floor(player.getPosition().y() - 0.1), player.getPosition().blockZ());
                    Block blockUnderPlayer = event.getInstance().getBlock(blockPosUnderPlayer);
                    if (blockUnderPlayer.compare(FINISH_BLOCK)) {
                        if (jump.getFinishPlate().equals(blockPosUnderPlayer)) {
                            long time = System.currentTimeMillis() - player.getTag(PLAYER_JUMP_START_TIME);
                            player.sendMessage(MM.deserialize("<green>Vous avez terminé le parcours en <white>" + time + "ms<green>."));

                            player.removeTag(PLAYER_JUMP);
                            player.removeTag(PLAYER_JUMP_START_TIME);
                            player.removeTag(CHECKPOINT_POS);

                            player.teleport(JumpInstance.SPAWN_POSITION);
                        } else {
                            player.sendMessage(MM.deserialize("<red>Ne trichez pas."));
                            finishJump(player, true);
                        }
                    }
                })
                .addListener(PlayerTickEvent.class, event -> {
                    Jumps jump = getPlayerJump(event.getPlayer());
                    if (jump == null) {
                        return;
                    }

                    String time = Utils.convertToReadableTime(System.currentTimeMillis() - event.getPlayer().getTag(PLAYER_JUMP_START_TIME));
                    event.getPlayer().sendActionBar(MM.deserialize("<green>Temps: <white>" + time));
                });
    }

    public static Jumps getPlayerJump(Player player) {
        return player.getTag(PLAYER_JUMP);
    }

    public static Pos getCurrentCheckpoint(Player player) {
        return player.getTag(CHECKPOINT_POS);
    }

    private static void finishJump(Player player, boolean teleport) {
        player.removeTag(PLAYER_JUMP);
        player.removeTag(PLAYER_JUMP_START_TIME);
        player.removeTag(CHECKPOINT_POS);

        if (teleport) player.teleport(JumpInstance.SPAWN_POSITION);
    }
}
