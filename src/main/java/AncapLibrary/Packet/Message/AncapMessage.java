package AncapLibrary.Packet.Message;

import AncapLibrary.Packet.ChatColorFormattable;
import AncapLibrary.Packet.Placeholderable;
import AncapLibrary.Packet.Sendable;

public class AncapMessage implements Placeholderable, ChatColorFormattable {

    private Sendable[] messages;

    AncapMessage(String[] messages) {
        this.messages = messages;
    }

    public void replace(String placeholder, String value) {
        for (int i = 0; i<messages.length; i++) {
            messages[i] = messages[i].replace(placeholder, value);
        }
    }

    public String[] getStrings() {
        return this.messages;
    }
}
