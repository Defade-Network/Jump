package net.defade.jump.map;

import net.defade.minestom.amethyst.AmethystSource;
import org.jetbrains.annotations.Nullable;
import java.io.InputStream;
import java.io.OutputStream;

public class JumpMapSource implements AmethystSource {
    @Override
    public @Nullable InputStream getAmethystSource() {
        return JumpMapSource.class.getClassLoader().getResourceAsStream("jump.amethyst");
    }

    @Override
    public @Nullable OutputStream getAmethystOutput() {
        return null;
    }
}
