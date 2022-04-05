package AncapLibrary.Configuration;

import AncapLibrary.Packet.Message.AncapMessage;
import AncapLibrary.Packet.AncapPacket;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class AncapLibraryConfiguration extends AncapConfiguration {

    public AncapLibraryConfiguration(FileConfiguration config) {
        super(config);
    }

    public AncapPacket getInvalidArgsCountMessage(Integer invalidCount, Integer acceptedCount) {
        AncapMessage ancapMessage = this.getMessage("invalid_args_count");
        ancapMessage.replace("%invalidCount%", invalidCount.toString());
        ancapMessage.replace("%acceptedCount%", acceptedCount.toString());
        return ancapMessage;
    }

    public AncapPacket getInvalidArgMessage(String invalid, List<String> accepted) {
        AncapMessage ancapMessage = this.getMessage("invalid_arg");
        ancapMessage.replace("%invalid%", invalid);
        ancapMessage.replace("%accepted%", String.join(" ,", accepted));
        return ancapMessage;
    }

    public AncapMessage getNoPermissionMessage() {
        return this.getMessage("no_perms");
    }
}
