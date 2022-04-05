package AncapLibrary.AncapEvents;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

public abstract class AncapEvent extends Event {

    public void call() {
        Bukkit.getPluginManager().callEvent(this);
    }
}
