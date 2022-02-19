package AncapLibrary.AncapEvents;

import AncapLibrary.Library.Interceptable;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AncapWorldSelfDestructEvent extends Event implements Cancellable, Interceptable {

    private Location[] locations = new Location[2];
    private Cancellable event;
    private boolean intercepted;

    public static final HandlerList handlers = new HandlerList();

    public AncapWorldSelfDestructEvent(Cancellable e, Location interacted, Location interacting) {
        event = e;
        locations[0] = interacted;
        locations[1] = interacting;
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

    @Override
    public boolean isIntercepted() {
        return this.intercepted;
    }

    @Override
    public void setIntercepted(boolean b) {
        this.intercepted = b;
    }
}
