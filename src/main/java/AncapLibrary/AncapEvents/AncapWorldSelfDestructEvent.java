package AncapLibrary.AncapEvents;

import AncapLibrary.Location.AncapLocation;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AncapWorldSelfDestructEvent extends AncapEvent implements Cancellable {

    private Cancellable event;
    private AncapLocation[] locations = new AncapLocation[2];
    private boolean intercepted;

    public static final HandlerList handlers = new HandlerList();

    public AncapWorldSelfDestructEvent(Cancellable e, AncapLocation interacted, AncapLocation interacting) {
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

    public AncapLocation[] getLocations() {
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
