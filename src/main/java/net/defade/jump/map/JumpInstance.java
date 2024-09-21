package net.defade.jump.map;

import net.defade.minestom.amethyst.AmethystLoader;
import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.world.DimensionType;

import java.util.UUID;

public class JumpInstance extends InstanceContainer {
    public JumpInstance() {
        super(UUID.randomUUID(), DimensionType.OVERWORLD);
        MinecraftServer.getInstanceManager().registerInstance(this);

        AmethystLoader amethystLoader = new AmethystLoader(this, new JumpMapSource());
        setChunkLoader(amethystLoader);
    }
}
