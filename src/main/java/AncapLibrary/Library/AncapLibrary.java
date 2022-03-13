package AncapLibrary.Library;

import AncapLibrary.Listeners.PrimalListeners.ExplodeListener;
import AncapLibrary.Listeners.PrimalListeners.PVPListener;
import AncapLibrary.Listeners.PrimalListeners.ProtectListener;
import AncapLibrary.Listeners.PrimalListeners.SelfDestructListener;
import AncapLibrary.Timer.Heartbeat.AncapHeartbeat;
import Database.Database;
import Database.Databases.BukkitConfigDatabase.BukkitConfigDatabase;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class AncapLibrary extends JavaPlugin {

    public static final int pluginId = 14261;

    private static AncapLibrary instance;

    private static Database database;

    @Override
    public void onEnable() {
        this.registerInstance();
        this.registerDatabase();
        this.registerEventsListeners();
        this.registerMetrics();
        this.startHeartbeat();
    }

    public static AncapLibrary getInstance() {
        return instance;
    }

    public static Database getConfiguredDatabase() {
        return database;
    }

    private void registerInstance() {
        instance = this;
    }

    private void registerDatabase() {
        database = new BukkitConfigDatabase("AncapLibraryDB.yml");
    }

    private void registerEventsListeners() {
        registerEventsListener(new ProtectListener());
        registerEventsListener(new PVPListener());
        registerEventsListener(new SelfDestructListener());
        registerEventsListener(new ExplodeListener());
    }

    private void startHeartbeat() {
        AncapHeartbeat heartbeat = new AncapHeartbeat();
        heartbeat.start();
    }

    private void registerMetrics() {
        Metrics metrics = new Metrics(this, pluginId);
    }

    public static void registerEventsListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, AncapLibrary.getInstance());
    }
}
