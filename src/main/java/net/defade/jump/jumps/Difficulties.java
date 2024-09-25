package net.defade.jump.jumps;

import net.kyori.adventure.text.Component;
import net.minestom.server.item.Material;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.TextColor.color;
import static net.kyori.adventure.text.format.TextDecoration.ITALIC;

public enum Difficulties {
    VERY_EASY(text("Très Facile").color(color(12, 203, 0)).decoration(ITALIC, false), Material.LIME_WOOL),
    EASY(text("Facile").color(color(0, 132, 30)).decoration(ITALIC, false), Material.GREEN_WOOL),
    MEDIUM(text("Moyen").color(color(255, 87, 0)).decoration(ITALIC, false), Material.YELLOW_WOOL),
    HARD(text("Difficile").color(color(228, 0, 0)).decoration(ITALIC, false), Material.ORANGE_WOOL),
    EXTREME(text("Extrême").color(color(168, 0, 0)).decoration(ITALIC, false), Material.RED_WOOL);

    private final Component name;
    private final Material item;

    Difficulties(Component name, Material item) {
        this.name = name;
        this.item = item;
    }

    public Component getName() {
        return name;
    }

    public Material getItem() {
        return item;
    }
}