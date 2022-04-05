package AncapLibrary.Location.CartesianCoordinates;

import org.bukkit.Location;

public class AncapCartesianPosition {

    private AncapX x;
    private AncapY y;
    private AncapZ z;

    public AncapCartesianPosition(AncapX x, AncapY y, AncapZ z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public AncapCartesianPosition(Location location) {
        this(new AncapX(location.getX()), new AncapY(location.getY()), new AncapZ(location.getZ()));
    }

    public boolean roundEquals(AncapCartesianPosition position) {
        return x.roundEquals(position.getX()) &&
                y.roundEquals(position.getY()) &&
                x.roundEquals(position.getZ());
    }

    protected AncapX getX() {
        return x;
    }

    protected AncapY getY() {
        return y;
    }

    protected AncapZ getZ() {
        return z;
    }

    @Override
    public String toString() {
        return x.toString()+";"+
                x.toString()+";"+
                z.toString();
    }
}
