package AncapLibrary.Listeners.PrimalListeners;

import AncapLibrary.AncapEvents.AncapVillagerHealEvent;
import AncapLibrary.Player.AncapPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagerHealListener implements Listener {

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        if (this.isHealingVillagerAt(e)) {
            AncapPlayer player = new AncapPlayer(e.getPlayer().getName());
            Villager villager = (Villager) e.getRightClicked();
            AncapVillagerHealEvent event = new AncapVillagerHealEvent(e, player, villager);
            Bukkit.getPluginManager().callEvent(event);
        }
    }

    private boolean isHealingVillagerAt(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType() == EntityType.ZOMBIE_VILLAGER && e.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE) {
            return true;
        }
        return false;
    }
}
