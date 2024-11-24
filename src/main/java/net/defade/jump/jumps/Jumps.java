package net.defade.jump.jumps;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.minestom.server.coordinate.BlockVec;
import net.minestom.server.coordinate.Pos;

import java.util.List;

import static net.defade.jump.jumps.Difficulties.*;

public enum Jumps {

    /*
     * ==========================
     *      VERY EASY DIFFICULTY
     * ==========================
     */

    THE_BEGINNING(VERY_EASY, MiniMessage.miniMessage().deserialize("<color:#FFFF41>The Beginning</color>"),
            5, 0, 7200,
            List.of(new BlockVec(5, 5, 11), new BlockVec(5, 5, 10), new BlockVec(5, 5, 9)), new BlockVec(-33, 13, 8), 90),

    VANILLA_LIKE(VERY_EASY, MiniMessage.miniMessage().deserialize("<color:#2DED21>Vanilla Like</color>"),
            5, 0, 15000,
            List.of(new BlockVec(5, 5, 23), new BlockVec(5, 5, 22), new BlockVec(5, 5, 21)), new BlockVec(-29, 14, 24), 90),

    TREE_ZOMIC(VERY_EASY, MiniMessage.miniMessage().deserialize("<color:#0D940D>Tree-Zomic</color>"),
            5, 5, 15000,
            List.of(new BlockVec(5, 5, 35), new BlockVec(5, 5, 34), new BlockVec(5, 5, 33)), new BlockVec(-16, 17, 33), 90),

    JUNGLE_TEMPLE(VERY_EASY, MiniMessage.miniMessage().deserialize("<color:#00E200>Jungle Temple</color>"),
            5, 5, 20000,
            List.of(new BlockVec(5, 5, 47), new BlockVec(5, 5, 46), new BlockVec(5, 5, 45)), new BlockVec(-16, 30, 46), 90),

    RAINBOWOOL(VERY_EASY, MiniMessage.miniMessage().deserialize("<gradient:#FF2A2A:#FF7F00>Ra</gradient><gradient:#FF7F00:#FFFF00>in</gradient><gradient:#FFFF00:#00FF00>bo</gradient><gradient:#00FF00:#4498DB>wWool</gradient>"),
            5, 5, 25000,
            List.of(new BlockVec(9, 5, 11), new BlockVec(9, 5, 10), new BlockVec(9, 5, 9)), new BlockVec(31, 20, 13), -90),

    HOT_SAND(VERY_EASY, MiniMessage.miniMessage().deserialize("<color:#FFFF41>Hot</color><color:#FFDC41> Sand</color>"),
            5, 5, 23000,
            List.of(new BlockVec(9, 5, 23), new BlockVec(9, 5, 22), new BlockVec(9, 5, 21)), new BlockVec(26, 24, 21), -90),

    ENDER_CHORUS(VERY_EASY, MiniMessage.miniMessage().deserialize("<color:#B641FF>Ender</color><color:#9041FF> Chorus</color>"),
            5, 5, 25000,
            List.of(new BlockVec(9, 5, 35), new BlockVec(9, 5, 34), new BlockVec(9, 5, 33)), new BlockVec(22, 25, 34), -90),

    AQUA_GUARDIAN(VERY_EASY, MiniMessage.miniMessage().deserialize("<color:#4184FF>Aqua Guardian</color>"),
            5, 5, 40000,
            List.of(new BlockVec(9, 5, 47), new BlockVec(9, 5, 46), new BlockVec(9, 5, 45)), new BlockVec(47, 30, 51), -90),

    /*
     * ==========================
     *      EASY DIFFICULTY
     * ==========================
     */

    BALLOONS(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<yellow>Bal</yellow><white>loo</white><light_purple>ns</light_purple>"),
            5, 5, 50000,
            List.of(new BlockVec(108, 5, -1), new BlockVec(107, 5, -1), new BlockVec(106, 5, -1)), new BlockVec(123, 30, -81), 180),

    FALL(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#FF593D>F</color><color:#FA4B31>a</color><color:#F63D25>l</color><color:#F23019>l</color>"),
            5, 5, 50000,
            List.of(new BlockVec(110, 5, 9), new BlockVec(110, 5, 8), new BlockVec(110, 5, 7)), new BlockVec(133, 34, 5), -90),

    DEAD_BUSH(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#FC7B35>Dead</color><color:#F24119> Bush</color>"),
            5, 5, 25000,
            List.of(new BlockVec(104, 5, 9), new BlockVec(104, 5, 8), new BlockVec(104, 5, 7)), new BlockVec(74, 37, 19), 90),

    POTATO(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#FFEC11>Potato</color>"),
            5, 5, 45000,
            List.of(new BlockVec(110, 5, 26), new BlockVec(110, 5, 25), new BlockVec(110, 5, 24)), new BlockVec(140, 28, 34), -90),

    SILVERFISH(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<gray>Silverfish</gray>"),
            5, 5, 35000,
            List.of(new BlockVec(104, 5, 26), new BlockVec(104, 5, 25), new BlockVec(104, 5, 24)), new BlockVec(73, 18, 34), 90),

    MINESHAFT(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#B06D00>Mineshaft</color>"),
            5, 5, 30000,
            List.of(new BlockVec(104, 5, 43), new BlockVec(104, 5, 42), new BlockVec(104, 5, 41)), new BlockVec(89, 27, 49), 90),

    SQUARE(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#969696>Squ</color><color:#6E6E6E>are</color>"),
            5, 5, 24000,
            List.of(new BlockVec(110, 5, 60), new BlockVec(110, 5, 59), new BlockVec(110, 5, 58)), new BlockVec(162, 19, 56), -90),

    BOOKSHELF(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<gold>Bookshelf</gold>"),
            5, 5, 25000,
            List.of(new BlockVec(104, 5, 60), new BlockVec(104, 5, 59), new BlockVec(104, 5, 58)), new BlockVec(76, 18, 64), 90),

    BUILDING(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#4A4A4A>Buil</color><color:#7D7D7D>ding</color>"),
            5, 5, 32000,
            List.of(new BlockVec(110, 5, 77), new BlockVec(110, 5, 76), new BlockVec(110, 5, 75)), new BlockVec(141, 35, 78), -90),

    ENCHANTING(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<gradient:#7C8EF1:#C230D4>Enchanting</gradient>"),
            5, 5, 37000,
            List.of(new BlockVec(104, 5, 77), new BlockVec(104, 5, 76), new BlockVec(104, 5, 75)), new BlockVec(71, 29, 89), 90),

    BONES(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#D9D9D9>Bones</color>"),
            5, 5, 16000,
            List.of(new BlockVec(110, 5, 94), new BlockVec(110, 5, 93), new BlockVec(110, 5, 92)), new BlockVec(122, 19, 90), -90),

    CRIMSON_ROOTS(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#FF2E2E>Crimson</color><color:#C90000> Roots</color>"),
            5, 5, 18000,
            List.of(new BlockVec(104, 5, 94), new BlockVec(104, 5, 93), new BlockVec(104, 5, 92)), new BlockVec(90, 19, 92), 90),

    MUSHROOMS(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<gray>Mush</gray><red>Rooms</red>"),
            5, 5, 23000,
            List.of(new BlockVec(110, 5, 111), new BlockVec(110, 5, 110), new BlockVec(110, 5, 109)), new BlockVec(117, 19, 118), -90),

    CARPENTRY(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<yellow>Carpentry</yellow>"),
            5, 5, 21000,
            List.of(new BlockVec(104, 5, 111), new BlockVec(104, 5, 110), new BlockVec(104, 5, 109)), new BlockVec(73, 21, 114), 90),

    WATER_BOTTLE(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#4394E6>Water</color><color:#4377E6> Bottle</color>"),
            5, 5, 15000,
            List.of(new BlockVec(110, 5, 129), new BlockVec(110, 5, 128), new BlockVec(110, 5, 127)), new BlockVec(121, 20, 128), -90),

    BLACKSTONE(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#323232>Black</color><color:#505050>stone</color>"),
            5, 5, 21000,
            List.of(new BlockVec(104, 5, 129), new BlockVec(104, 5, 128), new BlockVec(104, 5, 127)), new BlockVec(72, 17, 130), 90),

    BASALT_DELTA(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#6E6E6E>Basalt</color><color:#505050> Delta</color>"),
            5, 5, 18000,
            List.of(new BlockVec(110, 5, 146), new BlockVec(110, 5, 145), new BlockVec(110, 5, 144)), new BlockVec(124, 21, 149), -90),

    SNAKES(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#8CE349>Sna</color><color:#33C879>kes</color>"),
            5, 5, 16000,
            List.of(new BlockVec(104, 5, 146), new BlockVec(104, 5, 145), new BlockVec(104, 5, 144)), new BlockVec(89, 17, 143), 90),

    STRONGOLD(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#5A5A5A>Str</color><color:#828282>ong</color><color:#A0A0A0>old</color>"),
            5, 5, 23000,
            List.of(new BlockVec(110, 5, 167), new BlockVec(110, 5, 166), new BlockVec(110, 5, 165)), new BlockVec(167, 16, 177), -90),

    JUNGLE_TREES(Difficulties.EASY, MiniMessage.miniMessage().deserialize("<color:#1EA11B>Jungle</color><color:#4DED4A> Trees</color>"),
            5, 5, 20000,
            List.of(new BlockVec(104, 5, 167), new BlockVec(104, 5, 166), new BlockVec(104, 5, 165)), new BlockVec(66, 20, 170), 90);

    private final Difficulties difficulty;
    private final Component name;
    private final double crystalReward;
    private final double endermiteReward;
    private final int timeForReward;
    private final List<BlockVec> startPlates;
    private final BlockVec finishPlate;
    private final float startYaw;

    Jumps(Difficulties difficulty, Component name, double crystalReward, double endermiteReward, int timeForReward, List<BlockVec> startPlates, BlockVec finishPlate, float startYaw) {
        this.difficulty = difficulty;
        this.name = name;
        this.crystalReward = crystalReward;
        this.endermiteReward = endermiteReward;
        this.timeForReward = timeForReward;
        this.startPlates = startPlates;
        this.finishPlate = finishPlate;
        this.startYaw = startYaw;
    }

    public Difficulties getDifficulty() {
        return difficulty;
    }

    public Component getName() {
        return name;
    }

    public double getCrystalReward() {
        return crystalReward;
    }

    public double getEndermiteReward() {
        return endermiteReward;
    }

    public int getTimeForReward() {
        return timeForReward;
    }

    public List<BlockVec> getStartPlates() {
        return startPlates;
    }

    public Pos getMiddleStartPlate() {
        return new Pos(startPlates
                .get((startPlates.size() / 2))
                .add(0.5, 0, 0.5));
    }

    public BlockVec getFinishPlate() {
        return finishPlate;
    }

    public float getStartYaw() {
        return startYaw;
    }
}