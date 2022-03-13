package AncapLibrary.Listeners.PrimalListeners;

import AncapLibrary.AncapEvents.AncapExplodeEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplodeListener implements Listener {
    @EventHandler
    public void explodeEvent(EntityExplodeEvent e) {
        Location loc = e.getLocation();
        AncapExplodeEvent event = new AncapExplodeEvent(e, loc);
        Bukkit.getPluginManager().callEvent(event);
    }
}
