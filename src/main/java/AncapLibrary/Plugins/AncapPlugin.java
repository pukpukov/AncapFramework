package AncapLibrary.Plugins;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public abstract class AncapPlugin extends JavaPlugin {

    private Metrics metrics;

    @Override
    public void onEnable() {
        super.onEnable();
        this.registerBStats();
        this.registerEventsListeners();
        this.registerCommands();
    }

    private void registerEventsListeners() {
        for (Listener listener : this.getListeners()) {
            this.registerEventsListener(listener);
        }
    }

    private void registerBStats() {
        this.metrics = new Metrics(this, this.getPluginID());
    }

    protected Metrics getMetrics() {
        return this.metrics;
    }

    public void registerEventsListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    protected abstract List<Listener> getListeners();
    protected abstract int getPluginID();
}
