package AncapLibrary.Location;

import org.bukkit.Location;
import org.bukkit.World;

public class AncapWorld {

    private World world;

    public AncapWorld(World world) {
        this.world = world;
    }

    public AncapWorld(Location location) {
        this(location.getWorld());
    }

    public boolean equals(AncapWorld world) {
        return this.world.getName().equals(world.getWorld().getName());
    }

    protected World getWorld() {
        return this.world;
    }

    @Override
    public String toString() {
        return world.getName();
    }
}
