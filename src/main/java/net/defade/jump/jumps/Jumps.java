package net.defade.jump.jumps;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.coordinate.BlockVec;
import net.minestom.server.coordinate.Pos;

import java.util.List;

import static net.defade.jump.jumps.Difficulties.*;
import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.TextColor.color;

public enum Jumps {
    /*
     * ==========================
     *      VERY EASY DIFFICULTY
     * ==========================
     */

    THE_BEGINNING(VERY_EASY, text("The Beginning").color(color(255, 255, 65)),
            5, 0, 7200,
            List.of(new BlockVec(5, 5, 11), new BlockVec(5, 5, 10), new BlockVec(5, 5, 9)), new BlockVec(-33, 13, 8), 90),

    VANILLA_LIKE(VERY_EASY, text("Vanilla Like").color(color(45, 237, 33)),
            5, 0, 15000,
            List.of(new BlockVec(5, 5, 23), new BlockVec(5, 5, 22), new BlockVec(5, 5, 21)), new BlockVec(-29, 14, 24), 90),

    TREE_ZOMIC(VERY_EASY, text("Tree-Zomic").color(color(13, 148, 13)),
            5, 5, 15000,
            List.of(new BlockVec(5, 5, 35), new BlockVec(5, 5, 34), new BlockVec(5, 5, 33)), new BlockVec(-16, 17, 33), 90),

    JUNGLE_TEMPLE(VERY_EASY, text("Jungle Temple").color(color(0, 226, 0)),
            5, 5, 20000,
            List.of(new BlockVec(5, 5, 47), new BlockVec(5, 5, 46), new BlockVec(5, 5, 45)), new BlockVec(-16, 30, 46), 90),

    RAINBOWOOL(VERY_EASY, text("Rainbow").color(color(255, 0, 43)).append(text("Wool").color(color(255, 30, 0))),
            5, 5, 25000,
            List.of(new BlockVec(9, 5, 11), new BlockVec(9, 5, 10), new BlockVec(9, 5, 9)), new BlockVec(31, 20, 13), -90),

    HOT_SAND(VERY_EASY, text("Hot").color(color(255, 255, 65)).append(text(" Sand").color(color(255, 220, 65))),
            5, 5, 23000,
            List.of(new BlockVec(9, 5, 23), new BlockVec(9, 5, 22), new BlockVec(9, 5, 21)), new BlockVec(26, 24, 21), -90),

    ENDER_CHORUS(VERY_EASY, text("Ender").color(color(182, 65, 255)).append(text(" Chorus").color(color(144, 65, 255))),
            5, 5, 25000,
            List.of(new BlockVec(9, 5, 35), new BlockVec(9, 5, 34), new BlockVec(9, 5, 33)), new BlockVec(22, 25, 34), -90),

    AQUA_GUARDIAN(VERY_EASY, text("Aqua Guardian").color(color(65, 132, 255)),
            5, 5, 40000,
            List.of(new BlockVec(9, 5, 47), new BlockVec(9, 5, 46), new BlockVec(9, 5, 45)), new BlockVec(47, 30, 51), -90),

    /*
     * ==========================
     *      EASY DIFFICULTY
     * ==========================
     */

    BALLOONS(Difficulties.EASY, text("Bal").color(color(NamedTextColor.YELLOW)).append(text("loo").color(color(NamedTextColor.WHITE))
            .append(text("ns").color(color(NamedTextColor.LIGHT_PURPLE)))),
            5, 5, 50000,
            List.of(new BlockVec(108, 5, -1), new BlockVec(107, 5, -1), new BlockVec(106, 5, -1)), new BlockVec(123, 30, -81), 180),

    FALL(Difficulties.EASY, text("F").color(color(255, 89, 61)).append(text("a").color(color(250, 75, 49))
            .append(text("l").color(color(246, 61, 37)).append(text("l").color(color(242, 48, 25))))),
            5, 5, 50000,
            List.of(new BlockVec(110, 5, 9), new BlockVec(110, 5, 8), new BlockVec(110, 5, 7)), new BlockVec(133, 34, 5), -90),

    DEAD_BUSH(Difficulties.EASY, text("Dead").color(color(252, 123, 53)).append(text(" Bush").color(color(242, 65, 25))),
            5, 5, 25000,
            List.of(new BlockVec(104, 5, 9), new BlockVec(104, 5, 8), new BlockVec(104, 5, 7)), new BlockVec(74, 37, 19), 90),

    POTATO(Difficulties.EASY, text("Potato").color(color(255, 236, 17)),
            5, 5, 45000,
            List.of(new BlockVec(110, 5, 26), new BlockVec(110, 5, 25), new BlockVec(110, 5, 24)), new BlockVec(140, 28, 34), -90),

    SILVERFISH(Difficulties.EASY, text("Silverfish").color(color(NamedTextColor.GRAY)),
            5, 5, 35000,
            List.of(new BlockVec(104, 5, 26), new BlockVec(104, 5, 25), new BlockVec(104, 5, 24)), new BlockVec(73, 18, 34), 90),

    MINESHAFT(Difficulties.EASY, text("Mineshaft").color(color(176, 109, 0)),
            5, 5, 30000,
            List.of(new BlockVec(104, 5, 43), new BlockVec(104, 5, 42), new BlockVec(104, 5, 41)), new BlockVec(89, 27, 49), 90),

    SQUARE(Difficulties.EASY, text("Squ").color(color(150, 150, 150)).append(text("are").color(color(110, 110, 110))),
            5, 5, 24000,
            List.of(new BlockVec(110, 5, 60), new BlockVec(110, 5, 59), new BlockVec(110, 5, 58)), new BlockVec(162, 19, 56), -90),

    BOOKSHELF(Difficulties.EASY, text("Bookshelf").color(color(NamedTextColor.GOLD)),
            5, 5, 25000,
            List.of(new BlockVec(104, 5, 60), new BlockVec(104, 5, 59), new BlockVec(104, 5, 58)), new BlockVec(76, 18, 64), 90),

    BUILDING(Difficulties.EASY, text("Buil").color(color(74, 74, 74)).append(text("ding").color(color(125, 125, 125))),
            5, 5, 32000,
            List.of(new BlockVec(110, 5, 77), new BlockVec(110, 5, 76), new BlockVec(110, 5, 75)), new BlockVec(141, 35, 78), -90),

    ENCHANTING(Difficulties.EASY, text("Enchanting").color(color(136, 23, 235)),
            5, 5, 37000,
            List.of(new BlockVec(104, 5, 77), new BlockVec(104, 5, 76), new BlockVec(104, 5, 75)), new BlockVec(71, 29, 89), 90),

    BONES(Difficulties.EASY, text("Bones").color(color(217, 217, 217)),
            5, 5, 16000,
            List.of(new BlockVec(110, 5, 94), new BlockVec(110, 5, 93), new BlockVec(110, 5, 92)), new BlockVec(122, 19, 90), -90),

    CRIMSON_ROOTS(Difficulties.EASY, text("Crimson").color(color(255, 46, 46)).append(text(" Roots").color(color(201, 0, 0))),
            5, 5, 18000,
            List.of(new BlockVec(104, 5, 94), new BlockVec(104, 5, 93), new BlockVec(104, 5, 92)), new BlockVec(90, 19, 92), 90),

    MUSHROOMS(Difficulties.EASY, text("Mush").color(color(217, 217, 217)).append(text("Rooms").color(color(NamedTextColor.RED))),
            5, 5, 23000,
            List.of(new BlockVec(110, 5, 111), new BlockVec(110, 5, 110), new BlockVec(110, 5, 109)), new BlockVec(117, 19, 118), -90),

    CARPENTRY(Difficulties.EASY, text("Carpentry").color(color(255, 255, 65)),
            5, 5, 21000,
            List.of(new BlockVec(104, 5, 111), new BlockVec(104, 5, 110), new BlockVec(104, 5, 109)), new BlockVec(73, 21, 114), 90),

    WATER_BOTTLE(Difficulties.EASY, text("Water").color(color(67, 148, 230)).append(text(" Bottle").color(color(67, 119, 230))),
            5, 5, 15000,
            List.of(new BlockVec(110, 5, 129), new BlockVec(110, 5, 128), new BlockVec(110, 5, 127)), new BlockVec(121, 20, 128), -90),

    BLACKSTONE(Difficulties.EASY, text("Black").color(color(50, 50, 50)).append(text("stone").color(color(80, 80, 80))),
            5, 5, 21000,
            List.of(new BlockVec(104, 5, 129), new BlockVec(104, 5, 128), new BlockVec(104, 5, 127)), new BlockVec(72, 17, 130), 90),

    BASALT_DELTA(Difficulties.EASY, text("Basalt").color(color(110, 110, 110)).append(text(" Delta").color(color(80, 80, 80))),
            5, 5, 18000,
            List.of(new BlockVec(110, 5, 146), new BlockVec(110, 5, 145), new BlockVec(110, 5, 144)), new BlockVec(124, 21, 149), -90),

    SNAKES(Difficulties.EASY, text("Sna").color(color(140, 227, 73)).append(text("kes").color(color(51, 200, 121))),
            5, 5, 16000,
            List.of(new BlockVec(104, 5, 146), new BlockVec(104, 5, 145), new BlockVec(104, 5, 144)), new BlockVec(89, 17, 143), 90),

    STRONGOLD(Difficulties.EASY, text("Str").color(color(90, 90, 90)).append(text("ong").color(color(130, 130, 130))).append(text("old").color(color(160, 160, 160))),
            5, 5, 23000,
            List.of(new BlockVec(110, 5, 167), new BlockVec(110, 5, 166), new BlockVec(110, 5, 165)), new BlockVec(167, 16, 177), -90),

    JUNGLE_TREES(Difficulties.EASY, text("Jungle").color(color(30, 161, 27)).append(text(" Trees").color(color(77, 237, 74))),
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