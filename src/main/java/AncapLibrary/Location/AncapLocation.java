package AncapLibrary.Location;

import AncapLibrary.Location.CartesianCoordinates.AncapCartesianPosition;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class AncapLocation {

    private AncapWorld world;
    private AncapCartesianPosition position;

    public AncapLocation(AncapWorld world, AncapCartesianPosition position) {
        this.world = world;
        this.position = position;
    }

    public AncapLocation(Location location) {
        this(new AncapWorld(location), new AncapCartesianPosition(location));
    }

    public AncapLocation(Block block) {
        this(block.getLocation());
    }

    public boolean blockEquals(AncapLocation other) {
        return other.getWorld().equals(this.world) &&
                other.getPosition().roundEquals(this.position);
    }

    protected AncapWorld getWorld() {
        return world;
    }

    protected AncapCartesianPosition getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return world.toString()+";"+
                position.toString();
    }
}
