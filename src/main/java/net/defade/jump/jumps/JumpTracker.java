package net.defade.jump.jumps;

import net.defade.jump.data.PlayerStat;
import net.defade.jump.data.PlayerStatManager;
import net.defade.jump.event.PressurePlateEvent;
import net.defade.jump.map.JumpInstance;
import net.defade.jump.utils.Items;
import net.defade.jump.utils.Utils;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.title.TitlePart;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.BlockVec;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerMoveEvent;
import net.minestom.server.event.player.PlayerTickEvent;
import net.minestom.server.event.player.PlayerUseItemEvent;
import net.minestom.server.instance.block.Block;
import net.minestom.server.network.packet.server.play.ParticlePacket;
import net.minestom.server.particle.Particle;
import net.minestom.server.sound.SoundEvent;
import net.minestom.server.tag.Tag;

import java.time.Duration;

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

        player.getInventory().setItemStack(8, Items.QUIT_JUMP);
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

                        player.playSound(Sound.sound().type(SoundEvent.BLOCK_RESPAWN_ANCHOR_CHARGE).pitch(1).volume(0.4F).build());
                        player.sendTitlePart(TitlePart.TIMES, Title.Times.times(Duration.ofMillis(0),Duration.ofMillis(800),Duration.ofMillis(400)));
                        player.sendTitlePart(TitlePart.TITLE, MM.deserialize(""));
                        player.sendTitlePart(TitlePart.SUBTITLE, MM.deserialize("<b><green>Checkpoint!</green></b>"));
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

                    BlockVec blockPosUnderPlayer = new BlockVec(player.getPosition().sub(0, 0.1, 0));
                    Block blockUnderPlayer = event.getInstance().getBlock(blockPosUnderPlayer);
                    if (blockUnderPlayer.compare(FINISH_BLOCK)) {
                        if (!jump.getFinishPlate().equals(blockPosUnderPlayer)) {
                            player.sendMessage(MM.deserialize("<red>Ne trichez pas."));
                            finishJump(player, true);
                            return;
                        }

                        PlayerStat playerStat = PlayerStatManager.getPlayerStat(player);
                        long time = System.currentTimeMillis() - player.getTag(PLAYER_JUMP_START_TIME);

                        player.sendTitlePart(TitlePart.TIMES, Title.Times.times(Duration.ofMillis(0),Duration.ofMillis(4000),Duration.ofMillis(800)));
                        player.sendTitlePart(TitlePart.TITLE, MM.deserialize(""));
                        player.sendTitlePart(TitlePart.SUBTITLE, MM.deserialize("<jump_name><dark_gray> - <white>" + Utils.convertToReadableTime(time),
                                Placeholder.component("jump_name", jump.getName())
                        ));

                        Component challenge_time_component = Component.text("");
                        Component best_time_component = Component.text("");
                        boolean hasReward;
                        if (playerStat.hasRealizedJump(jump)) {
                            long previousTime = playerStat.getJumpTime(jump);
                            long timeForReward = jump.getTimeForReward();

                            if (previousTime >= timeForReward) { //Challenge never completed
                                best_time_component = Component.text("record: "  + Utils.convertToReadableTime(previousTime));
                                challenge_time_component = Component.text(", défi: " + Utils.convertToReadableTime(jump.getTimeForReward()));
                            }

                            if (time < previousTime) {
                                playerStat.updateJumpTime(jump, time);

                                player.sendTitlePart(TitlePart.TITLE, MM.deserialize("<b><gradient:#FFA751:#FFD959>RECORD BATTU!</gradient></b>"));
                                best_time_component = MiniMessage.miniMessage().deserialize("record: <previous_time> -> <yellow><best_time></yellow>",
                                            Placeholder.component("previous_time", Component.text(Utils.convertToReadableTime(previousTime))),
                                            Placeholder.component("best_time", Component.text(Utils.convertToReadableTime(time)))
                                        ); // Personal record
                            }

                            hasReward = previousTime > timeForReward && time <= timeForReward;

                            if (previousTime <= timeForReward && previousTime < time) //Challenge completed, but not personal record
                                best_time_component = Component.text("record: "  + Utils.convertToReadableTime(previousTime));

                        } else {
                            challenge_time_component = Component.text("défi: "  + Utils.convertToReadableTime(jump.getTimeForReward()));
                            best_time_component = Component.text("record: "  + Utils.convertToReadableTime(time));
                            playerStat.updateJumpTime(jump, time);
                            hasReward = time <= jump.getTimeForReward();
                        }

                        if (hasReward) {
                            player.sendMessage(MM.deserialize(
                                    "\n<gray>» <b><gradient:#FFE259:#FFA751>Défi Remporté!</gradient></b><gray> Vous recevez <yellow>⛃ " + jump.getCrystalReward() + " Coins " +
                                            "<gray>et <color:#14aeff>❂ " + jump.getEndermiteReward() + " Endermites<gray>!"));

                            player.playSound(Sound.sound().type(SoundEvent.BLOCK_BEACON_ACTIVATE).pitch(1).volume(1000).build());
                            player.sendPacket(new ParticlePacket(
                                    Particle.SOUL,
                                    true,
                                    JumpInstance.SPAWN_POSITION,
                                    Pos.ZERO,
                                    0.5F,
                                    30
                            ));
                            player.sendPacket(new ParticlePacket(
                                    Particle.SOUL_FIRE_FLAME,
                                    true,
                                    player.getPosition(),
                                    Pos.ZERO,
                                    0.5F,
                                    30
                            ));
                            player.sendPacket(new ParticlePacket(
                                    Particle.SOUL,
                                    true,
                                    player.getPosition(),
                                    Pos.ZERO,
                                    0.1F,
                                    20
                            ));
                            player.sendPacket(new ParticlePacket(
                                    Particle.SOUL_FIRE_FLAME,
                                    true,
                                    player.getPosition(),
                                    new Pos(0.25, 0.5, 0.25),
                                    0.1F,
                                    20
                            ));

                            challenge_time_component = Component.text(", défi: " + Utils.convertToReadableTime(jump.getTimeForReward()));

                            player.addCrystals(jump.getCrystalReward());
                            player.addEndermites(jump.getEndermiteReward());
                        }

                        player.sendMessage(MM.deserialize(
                                "<gray>» <color:#ffcc24>Vous avez fini le jump <jump> " +
                                        "<color:#ffcc24>en<color:#e6423c> <time> <color:#ffcc24>! <gray>(<best_time><challenge_time>)",
                                Placeholder.component("jump", jump.getName()),
                                Placeholder.component("time", Component.text(Utils.convertToReadableTime(time))),
                                Placeholder.component("challenge_time", challenge_time_component),
                                Placeholder.component("best_time", best_time_component)
                        ));


                        finishJump(player, true);
                        player.playSound(Sound.sound().type(SoundEvent.ENTITY_PLAYER_LEVELUP).pitch(1).volume(0.6F).build());
                    }
                })
                .addListener(PlayerTickEvent.class, event -> {
                    Player player = event.getPlayer();
                    Jumps jump = getPlayerJump(player);
                    if (jump == null) {
                        return;
                    }

                    String time = Utils.convertToReadableTime(System.currentTimeMillis() - player.getTag(PLAYER_JUMP_START_TIME));
                    player.sendActionBar(MM.deserialize("<jump_name><dark_gray> - <white>" + time,
                            Placeholder.component("jump_name", jump.getName())
                    ));

                    player.sendPacket(new ParticlePacket(
                            Particle.END_ROD,
                            true,
                            jump.getFinishPlate().add(0.5, 0.5, 0.5),
                            new Pos(0.25, 0.25, 0.25),
                            0.05F,
                            1
                    ));
                })
                .addListener(PlayerUseItemEvent.class, event -> {
                    Player player = event.getPlayer();

                    if (event.getItemStack().isSimilar(Items.QUIT_JUMP)) {
                        finishJump(player, false);

                        player.sendMessage(MM.deserialize("<gray>» <red>Vous avez quitté le jump!"));
                        player.teleport(JumpInstance.SPAWN_POSITION);

                        player.playSound(Sound.sound().type(SoundEvent.BLOCK_BEACON_DEACTIVATE).pitch(1).volume(0.4F).build());
                        player.sendPacket(new ParticlePacket(
                                Particle.ASH,
                                true,
                                player.getPosition(),
                                new Pos(1, 2, 1),
                                0.1F,
                                200
                        ));
                        player.sendPacket(new ParticlePacket(
                                Particle.LARGE_SMOKE,
                                true,
                                player.getPosition(),
                                new Pos(1, 0.7, 1),
                                0.1F,
                                20
                        ));
                    }
                });
    }

    public static Jumps getPlayerJump(Player player) {
        return player.getTag(PLAYER_JUMP);
    }

    public static Pos getCurrentCheckpoint(Player player) {
        return player.getTag(CHECKPOINT_POS);
    }

    private static void finishJump(Player player, boolean teleport) {
        if (teleport) player.teleport(getPlayerJump(player).getMiddleStartPlate().withYaw(getPlayerJump(player).getStartYaw()));

        player.removeTag(PLAYER_JUMP);
        player.removeTag(PLAYER_JUMP_START_TIME);
        player.removeTag(CHECKPOINT_POS);

        player.getInventory().setItemStack(8, Items.HUB);
    }
}
