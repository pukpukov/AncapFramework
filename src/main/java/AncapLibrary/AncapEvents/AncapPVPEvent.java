package AncapLibrary.AncapEvents;

import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AncapPVPEvent extends AncapEvent implements Cancellable {

    private Location[] locations = new Location[2];
    private Cancellable event;
    private boolean intercepted;
    public static final HandlerList handlers = new HandlerList();

    public AncapPVPEvent(Cancellable event, Location loc0, Location loc1) {
        this.locations[0] = loc0;
        this.locations[1] = loc1;
        this.event = event;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Location[] getLocations() {
        return this.locations;
    }

    public Cancellable getBukkitEvent() {
        return this.event;
    }

    @Override
    public boolean isCancelled() {
        return event.isCancelled();
    }

    @Override
    public void setCancelled(boolean b) {
        event.setCancelled(b);
    }
}
