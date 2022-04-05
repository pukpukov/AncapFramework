package AncapLibrary.Packet;

public interface ChatColorFormattable extends Replaceable {

    default void setChatColor() {
        this.replace("&", "§");
    }
}
