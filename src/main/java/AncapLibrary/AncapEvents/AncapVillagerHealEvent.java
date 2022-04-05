package AncapLibrary.AncapEvents;

import AncapLibrary.Player.AncapPlayer;
import org.bukkit.entity.Villager;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AncapVillagerHealEvent extends AncapEvent implements Cancellable {


    private boolean intercepted;

    private final Cancellable event;

    private final AncapPlayer player;

    private final Villager villager;

    public AncapVillagerHealEvent(Cancellable event, AncapPlayer player, Villager villager) {
        this.event = event;
        this.player = player;
        this.villager = villager;
    }

    public static final HandlerList handlers = new HandlerList();

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return this.event.isCancelled();
    }

    @Override
    public void setCancelled(boolean b) {
        this.event.setCancelled(b);
    }

    public Cancellable getBukkitEvent() {
        return this.event;
    }

    public AncapPlayer getPlayer() {
        return this.player;
    }

    public Villager getVillager() {
        return this.villager;
    }

}
