package AncapLibrary.Player;

import AncapLibrary.API.SMassiveAPI;
import AncapLibrary.Economy.Balance;
import AncapLibrary.Library.AncapLibrary;
import AncapLibrary.Library.BalanceHolder;
import AncapLibrary.Message.Message;
import Database.Database;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class AncapPlayer implements BalanceHolder {

    private String id;
    private String name;
    private Database statesDB = AncapLibrary.getConfiguredDatabase();
    public static Logger log = Bukkit.getLogger();

    public AncapPlayer(Player player) {
        this.name = player.getName();
        this.id = name.toLowerCase();
        this.create();
    }

    public AncapPlayer(String name) {
        this.id = name.toLowerCase();
        this.create();
    }

    @Override
    public void setMeta(String field, String str) {
        statesDB.write("states.player."+this.getID()+"."+field, str);
    }

    @Override
    public String getMeta(String field) {
        return statesDB.getString("states.player."+this.getID()+"."+field);
    }

    @Override
    public Balance getBalance() {
        return new Balance(this);
    }

    @Override
    public void setBalance(Balance balance) {
        statesDB.write("states.player."+this.getID()+".balance.iron", String.valueOf(balance.getIron()));
        statesDB.write("states.player."+this.getID()+".balance.diamond", String.valueOf(balance.getDiamond()));
        statesDB.write("states.player."+this.getID()+".balance.netherite", String.valueOf(balance.getNetherite()));
        return;
    }

    public Location getLocation() {
        return this.getPlayer().getLocation();
    }

    public void sendMessage(Message message) {
        String[] messages = message.getStrings();
        for (int i = 0; i<messages.length; i++) {
            if (messages[i] == null) {
                continue;
            }
            this.sendMessage(messages[i].replace("&", "§"));
        }
    }

    public void sendMessage(String string) {
        try {
            Player p = this.getPlayer();
            p.sendMessage(string.replace("&","§"));
        } catch (Exception ignored) {}
    }

    public void playSound(Sound sound) {
        try {
            Player p = this.getPlayer();
            p.playSound(p.getLocation(), sound, 1000, 1);
        } catch (Exception ignored) {}
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(this.id);
    }

    public String getName() {
        return statesDB.getString("states.player."+id+".name");
    }

    public void create() {
        if (!this.created()) {
            statesDB.write("states.player."+this.id+".name", id);
            if (this.name != null) {
                statesDB.write("states.player."+this.id+".name", name);
            }
        }
    }

    public String getID() {
        return this.id;
    }

    public void setUp() {
        statesDB.write("states.player."+this.id+".name", this.getPlayer().getName());
    }

    public boolean created() {
        return statesDB.isSet("states.player."+this.id+".name");
    }

    public void updateName() {
        statesDB.write("states.player."+this.id+".name", this.getPlayer().getName());
    }

    @Override
    public String toString() {
        return "AncapPlayer{"+this.getID()+"}";
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null) {
            return false;
        }
        if (!AncapPlayer.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        AncapPlayer other = (AncapPlayer) obj;
        return other.getID().equals(this.getID());
    }

    public boolean haveFlag(String string) {
        return SMassiveAPI.contain(statesDB.getString("states.player."+this.getID()+".flags"), string);
    }
}
