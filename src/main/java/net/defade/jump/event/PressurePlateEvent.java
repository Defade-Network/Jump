package net.defade.jump.event;

import net.minestom.server.coordinate.Point;
import net.minestom.server.entity.Player;
import net.minestom.server.event.trait.PlayerEvent;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public class PressurePlateEvent implements PlayerEvent {
    private final Player player;
    private final Block pressurePlate;
    private final Point pos;

    private final boolean isPressed;

    public PressurePlateEvent(Player player, Block pressurePlate, Point pos, boolean isPressed) {
        this.player = player;
        this.pressurePlate = pressurePlate;
        this.pos = pos;
        this.isPressed = isPressed;
    }

    public Block getPressurePlate() {
        return pressurePlate;
    }

    public Point getPos() {
        return pos;
    }

    public boolean isPressed() {
        return isPressed;
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}
