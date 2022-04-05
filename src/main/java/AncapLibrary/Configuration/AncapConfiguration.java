package AncapLibrary.Configuration;

import AncapLibrary.Economy.Balance;
import AncapLibrary.Economy.ParsedStringPreBalance;
import AncapLibrary.Packet.Message.AncapMessage;
import AncapLibrary.StringParser.ParsedString;
import AncapLibrary.StringParser.PreParsedString;
import org.bukkit.configuration.file.FileConfiguration;

public abstract class AncapConfiguration {

    private FileConfiguration fileConfiguration;

    public AncapConfiguration(FileConfiguration fileConfiguration) {
        this.fileConfiguration = fileConfiguration;
    }

    protected FileConfiguration getFileConfiguration() {
        return this.fileConfiguration;
    }

    public AncapMessage getMessage(String path) {
        AncapMessage ancapMessage = new AncapMessage(new String[]{fileConfiguration.getString(path)});
        ancapMessage.setChatColor();
        return ancapMessage;
    }

    public Balance getBalance(String path) {
        String data = fileConfiguration.getString(path);
        ParsedString string = new PreParsedString(data).parse(":", ";");
        return new ParsedStringPreBalance(string).getPreparedBalance();
    }

}
