package AncapLibrary.Library;

import AncapLibrary.Commands.Command;
import AncapLibrary.Configuration.AncapLibraryConfiguration;
import AncapLibrary.Listeners.PrimalListeners.*;
import AncapLibrary.Plugins.AncapPlugin;
import AncapLibrary.Timer.Heartbeat.AncapHeartbeat;
import Database.Database;
import Database.Databases.BukkitConfigDatabase.BukkitConfigDatabase;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class AncapLibrary extends AncapPlugin {

    public static final int pluginId = 14261;

    private static AncapLibrary plugin;
    private static AncapLibraryConfiguration configuration;
    private static Database database;

    private final List<Command> commands = new ArrayList(Arrays.asList(
            new
    ));

    private final List<Listener> listeners = new ArrayList(Arrays.asList(
            new ProtectListener(),
            new PVPListener(),
            new SelfDestructListener(),
            new ExplodeListener(),
            new VillagerHealListener()
    ));

    @Override
    public void onEnable() {
        super.onEnable();
        this.registerInstance();
        this.loadDatabase();
        this.loadConfiguration();
        this.registerEventsListeners();
        this.startHeartbeat();
        this.startTimers();
        this.finishLoading();
    }

    private void finishLoading() {

    }

    private void startTimers() {

    }

    private void startHeartbeat() {
        AncapHeartbeat heartbeat = new AncapHeartbeat();
        heartbeat.start();
    }


    private void registerEventsListeners() {
        registerEventsListener(new ProtectListener());
        registerEventsListener(new PVPListener());
        registerEventsListener(new SelfDestructListener());
        registerEventsListener(new ExplodeListener());
        registerEventsListener(new VillagerHealListener());
    }

    @Override
    protected List<Listener> getListeners() {
        return listeners;
    }

    @Override
    protected int getPluginID() {
        return pluginId;
    }


    private void loadDatabase() {
        database = new BukkitConfigDatabase("AncapLibraryDB.yml");
    }


    private void loadConfiguration() {
        this.saveDefaultConfig();
        configuration = new AncapLibraryConfiguration(this.getConfig());
    }

    private void registerInstance() {
        instance = this;
    }

    public static AncapLibraryConfiguration getConfiguration() {
        return configuration;
    }

    public static Database getConfiguredDatabase() {
        return database;
    }
}
