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
    THE_BEGINNING(VERY_EASY, text("The Beginning").color(color(255, 255, 65)),
            5, 0, 7200,
            List.of(new BlockVec(5, 5, 11), new BlockVec(5, 5, 10), new BlockVec(5, 5, 9)), new BlockVec(-33, 114, 8), 90),

    VANILLA_LIKE(VERY_EASY, text("Vanilla Like").color(color(45, 237, 33)),
            5, 0, 15000,
            List.of(new BlockVec(5, 5, 23), new BlockVec(5, 5, 22), new BlockVec(5, 5, 21)), new BlockVec(-29, 115, 24), 90),

    TREE_ZOMIC(VERY_EASY, text("Tree-Zomic").color(color(13, 148, 13)),
            5, 5, 15000,
            List.of(new BlockVec(5, 5, 35), new BlockVec(5, 5, 34), new BlockVec(5, 5, 33)), new BlockVec(-16, 118, 33), 90),

    JUNGLE_TEMPLE(VERY_EASY, text("Jungle Temple").color(color(0, 226, 0)),
            5, 5, 20000,
            List.of(new BlockVec(5, 5, 47), new BlockVec(5, 5, 46), new BlockVec(5, 5, 45)), new BlockVec(-16, 131, 46), 90),

    RAINBOWOOL(VERY_EASY, text("Rainbow").color(color(255, 0, 43)).append(text("Wool").color(color(255, 30, 0))),
            5, 5, 25000,
            List.of(new BlockVec(9, 5, 11), new BlockVec(9, 5, 10), new BlockVec(9, 5, 9)), new BlockVec(31, 121, 13), -90),

    HOT_SAND(VERY_EASY, text("Hot").color(color(255, 255, 65)).append(text(" Sand").color(color(255, 220, 65))),
            5, 5, 23000,
            List.of(new BlockVec(9, 5, 23), new BlockVec(9, 5, 22), new BlockVec(9, 5, 21)), new BlockVec(26, 125, 21), -90),

    ENDER_CHORUS(VERY_EASY, text("Ender").color(color(182, 65, 255)).append(text(" Chorus").color(color(144, 65, 255))),
            5, 5, 25000,
            List.of(new BlockVec(9, 5, 35), new BlockVec(9, 5, 34), new BlockVec(9, 5, 33)), new BlockVec(22, 126, 34), -90),

    AQUA_GUARDIAN(VERY_EASY, text("Aqua Guardian").color(color(65, 132, 255)),
            5, 5, 40000,
            List.of(new BlockVec(9, 5, 47), new BlockVec(9, 5, 46), new BlockVec(9, 5, 45)), new BlockVec(47, 131, 51), -90),

    MOSSY_BRICKS(VERY_EASY, text("Mossy").color(color(37, 112, 40)).append(text(" Bricks").color(color(63, 115, 53))),
            5, 5, 15000,
            List.of(new BlockVec(5, 5, 59), new BlockVec(5, 5, 58), new BlockVec(5, 5, 57)), new BlockVec(-24, 116, 61), 90),

    OAK_TREES(VERY_EASY, text("Oak Trees").color(color(120, 201, 26)),
            5, 5, 25000,
            List.of(new BlockVec(9, 5, 59), new BlockVec(9, 5, 58), new BlockVec(9, 5, 57)), new BlockVec(18, 120, 61), -90),

    AMETHYST_CRYSTAL(VERY_EASY, text("Amethyst").color(color(112, 53, 115)).append(text(" Crystal").color(color(148, 58, 153))),
            5, 5, 20000,
            List.of(new BlockVec(5, 5, 71), new BlockVec(5, 5, 70), new BlockVec(5, 5, 69)), new BlockVec(-5, 116, 72), 90),

    BIRCH_FOREST(VERY_EASY, text("Birch Forest").color(color(207, 190, 45)),
            5, 5, 15000,
            List.of(new BlockVec(9, 5, 71), new BlockVec(9, 5, 70), new BlockVec(9, 5, 69)), new BlockVec(17, 117, 77), -90),

    DARK_RUINS(VERY_EASY, text("Dark").color(color(49, 50, 61)).append(text(" Ruins").color(color(102, 102, 102))),
            5, 5, 20000,
            List.of(new BlockVec(5, 5, 83), new BlockVec(5, 5, 82), new BlockVec(5, 5, 81)), new BlockVec(-39, 116, 85), 90),

    COPPER_COGS(VERY_EASY, text("Copper").color(color(235, 122, 52)).append(text(" Cogs").color(color(237, 104, 21))),
            5, 5, 20000,
            List.of(new BlockVec(9, 5, 83), new BlockVec(9, 5, 82), new BlockVec(9, 105, 81)), new BlockVec(45, 116, 94), -90),

    BEEHIVE(VERY_EASY, text("Beehive").color(color(212, 209, 36)),
            5, 5, 20000,
            List.of(new BlockVec(5, 105, 95), new BlockVec(5, 105, 94), new BlockVec(5, 105, 93)), new BlockVec(-10, 119, 103), 90),

    ANDESITE(VERY_EASY, text("Andesite").color(color(101, 106, 191)),
            5, 5, 20000,
            List.of(new BlockVec(9, 105, 95), new BlockVec(9, 105, 94), new BlockVec(9, 105, 93)), new BlockVec(38, 115, 100), -90),

    NETHER_BRICKS(VERY_EASY, text("Nether Bricks").color(color(179, 34, 23)),
            5, 5, 20000,
            List.of(new BlockVec(5, 105, 107), new BlockVec(5, 105, 106), new BlockVec(5, 105, 5)), new BlockVec(-60, 123, 109), 90),

    RED_BASALT(VERY_EASY, text("Red").color(color(191, 101, 101)).append(text(" Basalt").color(color(97, 58, 58))),
            5, 5, 20000,
            List.of(new BlockVec(9, 5, 107), new BlockVec(9, 5, 106), new BlockVec(9, 5, 105)), new BlockVec(34, 121, 110), -90),

    GROWTH_TAIGA(VERY_EASY, text("Mossy").color(color(44, 145, 16)).append(text(" Taiga").color(color(32, 153, 21))),
            5, 5, 20000,
            List.of(new BlockVec(5, 5, 119), new BlockVec(5, 5, 118), new BlockVec(5, 5, 117)), new BlockVec(-41, 124, 119), 90),

    ACACIA_FOREST(VERY_EASY, text("Acacia").color(color(156, 179, 23)).append(text(" Forest").color(color(96, 179, 23))),
            5, 5, 20000,
            List.of(new BlockVec(9, 5, 119), new BlockVec(9, 5, 118), new BlockVec(9, 5, 117)), new BlockVec(37, 120, 127), -90),

    SOULSAND_VALLEY(VERY_EASY, text("Soulsand").color(color(106, 82, 68)).append(text(" Valley").color(color(1, 188, 194))),
            5, 5, 20000,
            List.of(new BlockVec(9, 5, 131), new BlockVec(9, 5, 130), new BlockVec(9, 5, 129)), new BlockVec(17, 115, 133), -90),

    BALLOONS(Difficulties.EASY, text("Bal").color(color(NamedTextColor.YELLOW)).append(text("loo").color(color(NamedTextColor.WHITE))
            .append(text("ns").color(color(NamedTextColor.LIGHT_PURPLE)))),
            5, 5, 50000,
            List.of(new BlockVec(108, 5, -1), new BlockVec(107, 5, -1), new BlockVec(106, 5, -1)), new BlockVec(123, 132, -82), 180),

    FALL(Difficulties.EASY, text("F").color(color(255, 89, 61)).append(text("a").color(color(250, 75, 49))
            .append(text("l").color(color(246, 61, 37)).append(text("l").color(color(242, 48, 25))))),
            5, 5, 50000,
            List.of(new BlockVec(110, 5, 9), new BlockVec(110, 5, 8), new BlockVec(110, 5, 7)), new BlockVec(133, 135, 5), -90),

    DEAD_BUSH(Difficulties.EASY, text("Dead").color(color(252, 123, 53)).append(text(" Bush").color(color(242, 65, 25))),
            5, 5, 25000,
            List.of(new BlockVec(104, 5, 9), new BlockVec(104, 5, 8), new BlockVec(104, 5, 7)), new BlockVec(74, 138, 19), 90),

    POTATO(Difficulties.EASY, text("Potato").color(color(255, 236, 17)),
            5, 5, 45000,
            List.of(new BlockVec(110, 5, 26), new BlockVec(110, 5, 25), new BlockVec(110, 5, 24)), new BlockVec(140, 129, 34), -90),

    SILVERFISH(Difficulties.EASY, text("Silverfish").color(color(NamedTextColor.GRAY)),
            5, 5, 35000,
            List.of(new BlockVec(104, 5, 26), new BlockVec(104, 5, 25), new BlockVec(104, 5, 24)), new BlockVec(73, 119, 34), 90),

    MINESHAFT(Difficulties.EASY, text("Mineshaft").color(color(176, 109, 0)),
            5, 5, 30000,
            List.of(new BlockVec(104, 5, 43), new BlockVec(104, 5, 42), new BlockVec(104, 5, 41)), new BlockVec(89, 128, 49), 90),

    SQUARE(Difficulties.EASY, text("Squ").color(color(150, 150, 150)).append(text("are").color(color(110, 110, 110))),
            5, 5, 24000,
            List.of(new BlockVec(110, 5, 60), new BlockVec(110, 5, 59), new BlockVec(110, 5, 58)), new BlockVec(162, 120, 56), -90),

    BOOKSHELF(Difficulties.EASY, text("Bookshelf").color(color(NamedTextColor.GOLD)),
            5, 5, 25000,
            List.of(new BlockVec(104, 5, 60), new BlockVec(104, 5, 59), new BlockVec(104, 5, 58)), new BlockVec(76, 119, 64), 90),

    BUILDING(Difficulties.EASY, text("Buil").color(color(74, 74, 74)).append(text("ding").color(color(125, 125, 125))),
            5, 5, 32000,
            List.of(new BlockVec(110, 5, 77), new BlockVec(110, 5, 76), new BlockVec(110, 5, 75)), new BlockVec(141, 136, 78), -90),

    ENCHANTING(Difficulties.EASY, text("Enchanting").color(color(136, 23, 235)),
            5, 5, 37000,
            List.of(new BlockVec(104, 5, 77), new BlockVec(104, 5, 76), new BlockVec(104, 5, 75)), new BlockVec(71, 130, 89), 90),

    BONES(Difficulties.EASY, text("Bones").color(color(217, 217, 217)),
            5, 5, 16000,
            List.of(new BlockVec(110, 5, 94), new BlockVec(110, 5, 93), new BlockVec(110, 5, 92)), new BlockVec(122, 120, 90), -90),

    CRIMSON_ROOTS(Difficulties.EASY, text("Crimson").color(color(255, 46, 46)).append(text(" Roots").color(color(201, 0, 0))),
            5, 5, 18000,
            List.of(new BlockVec(104, 5, 94), new BlockVec(104, 5, 93), new BlockVec(104, 5, 92)), new BlockVec(90, 120, 92), 90),

    MUSHROOMS(Difficulties.EASY, text("Mush").color(color(217, 217, 217)).append(text("Rooms").color(color(NamedTextColor.RED))),
            5, 5, 23000,
            List.of(new BlockVec(110, 5, 111), new BlockVec(110, 5, 110), new BlockVec(110, 5, 109)), new BlockVec(117, 120, 118), -90),

    CARPENTRY(Difficulties.EASY, text("Carpentry").color(color(255, 255, 65)),
            5, 5, 21000,
            List.of(new BlockVec(104, 5, 111), new BlockVec(104, 5, 110), new BlockVec(104, 5, 109)), new BlockVec(73, 122, 114), 90),

    WATER_BOTTLE(Difficulties.EASY, text("Water").color(color(67, 148, 230)).append(text(" Bottle").color(color(67, 119, 230))),
            5, 5, 15000,
            List.of(new BlockVec(110, 5, 129), new BlockVec(110, 5, 128), new BlockVec(110, 5, 127)), new BlockVec(120, 120, 127), -90),

    BLACKSTONE(Difficulties.EASY, text("Black").color(color(50, 50, 50)).append(text("stone").color(color(80, 80, 80))),
            5, 5, 21000,
            List.of(new BlockVec(104, 5, 129), new BlockVec(104, 5, 128), new BlockVec(104, 5, 127)), new BlockVec(72, 118, 130), 90),

    BASALT_DELTA(Difficulties.EASY, text("Basalt").color(color(110, 110, 110)).append(text(" Delta").color(color(80, 80, 80))),
            5, 5, 18000,
            List.of(new BlockVec(110, 5, 146), new BlockVec(110, 5, 145), new BlockVec(110, 5, 144)), new BlockVec(124, 122, 149), -90),

    SNAKES(Difficulties.EASY, text("Sna").color(color(140, 227, 73)).append(text("kes").color(color(51, 200, 121))),
            5, 5, 16000,
            List.of(new BlockVec(104, 5, 146), new BlockVec(104, 5, 145), new BlockVec(104, 5, 144)), new BlockVec(89, 118, 143), 90),

    STRONGOLD(Difficulties.EASY, text("Str").color(color(90, 90, 90)).append(text("ong").color(color(130, 130, 130))).append(text("old").color(color(160, 160, 160))),
            5, 5, 23000,
            List.of(new BlockVec(110, 5, 167), new BlockVec(110, 5, 166), new BlockVec(110, 5, 165)), new BlockVec(167, 117, 177), -90),

    JUNGLE_TREES(Difficulties.EASY, text("Jungle").color(color(30, 161, 27)).append(text(" Trees").color(color(77, 237, 74))),
            5, 5, 20000,
            List.of(new BlockVec(104, 5, 167), new BlockVec(104, 5, 166), new BlockVec(104, 5, 165)), new BlockVec(66, 121, 170), 90),

    NETHER_FIELDS(Difficulties.EASY, text("Nether").color(color(255, 36, 36)).append(text(" Fields").color(color(201, 14, 14))),
            5, 5, 33000,
            List.of(new BlockVec(110, 5, 189), new BlockVec(110, 5, 188), new BlockVec(110, 5, 187)), new BlockVec(164, 125, 202), -90),

    OVERGROWNED_DEEPSLATE(Difficulties.EASY, text("Overgrowned").color(color(70, 171, 70)).append(text(" Deepslate").color(color(44, 145, 69))),
            5, 5, 19000,
            List.of(new BlockVec(104, 5, 189), new BlockVec(104, 5, 188), new BlockVec(104, 5, 187)), new BlockVec(88, 118, 198), 90),

    LUSH(Difficulties.EASY, text("Lu").color(color(39, 232, 71)).append(text("sh").color(color(39, 232, 110))),
            5, 5, 20000,
            List.of(new BlockVec(110, 5, 211), new BlockVec(110, 5, 210), new BlockVec(110, 5, 209)), new BlockVec(116, 5, 203), -90),

    WINDY_AZALEA(Difficulties.EASY, text("Windy").color(color(37, 207, 71)).append(text(" Azalea").color(color(68, 232, 39))),
            5, 5, 21000,
            List.of(new BlockVec(104, 5, 211), new BlockVec(104, 5, 210), new BlockVec(104, 5, 209)), new BlockVec(48, 121, 214), 90),

    WET_TAIGA(Difficulties.EASY, text("Wet").color(color(60, 127, 186)).append(text(" Taiga").color(color(60, 186, 115))),
            5, 5, 33000,
            List.of(new BlockVec(110, 5, 233), new BlockVec(110, 5, 232), new BlockVec(110, 5, 231)), new BlockVec(136, 118, 238), -90),

    MESA(Difficulties.EASY, text("Mesa").color(color(219, 124, 35)),
            5, 5, 21000,
            List.of(new BlockVec(104, 5, 233), new BlockVec(104, 5, 232), new BlockVec(104, 5, 231)), new BlockVec(90, 131, 230), 90),

    BRICKS(Difficulties.EASY, text("Br").color(color(204, 88, 59)).append(text("ic").color(color(181, 168, 164))
            .append(text("ks").color(color(204, 88, 59)))),
            5, 5, 33000,
            List.of(new BlockVec(110, 5, 255), new BlockVec(110, 5, 254), new BlockVec(110, 5, 253)), new BlockVec(133, 118, 253), -90),

    AMETHYST_GEODES(Difficulties.EASY, text("Amethyst").color(color(112, 53, 115)).append(text(" Geodes").color(color(179, 178, 173))),
            5, 5, 21000,
            List.of(new BlockVec(104, 5, 255), new BlockVec(104, 5, 254), new BlockVec(104, 5, 253)), new BlockVec(39, 123, 264), 90),

    DRY_SAVANNA(Difficulties.MEDIUM, text("Dry").color(color(155, 186, 52)).append(text(" Savanna").color(color(201, 201, 48))),
            5, 5, 31000,
            List.of(new BlockVec(304, 106, 9), new BlockVec(304, 106, 8), new BlockVec(304, 106, 7)), new BlockVec(292, 125, -2), 90),

    CRIMSON_FOREST(Difficulties.MEDIUM, text("Crimson").color(color(201, 48, 48)).append(text(" Forest").color(color(161, 21, 0))),
            5, 5, 31000,
            List.of(new BlockVec(310, 106, 9), new BlockVec(310, 106, 8), new BlockVec(310, 106, 7)), new BlockVec(341, 118, -2), -90),

    COMPLEX_LIBRARY(Difficulties.MEDIUM, text("Complex").color(color(201, 0, 13)).append(text(" Library").color(color(153, 0, 10))),
            5, 5, 31000,
            List.of(new BlockVec(304, 106, 29), new BlockVec(304, 106, 28), new BlockVec(304, 106, 27)), new BlockVec(274, 126, 35), 90),

    ROOFED_FOREST(Difficulties.MEDIUM, text("Roofed").color(color(138, 56, 12)).append(text(" Forest").color(color(26, 110, 28))),
            5, 5, 31000,
            List.of(new BlockVec(310, 106, 29), new BlockVec(310, 106, 28), new BlockVec(310, 106, 27)), new BlockVec(337, 126, 22), -90);

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