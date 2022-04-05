package AncapLibrary.Packet;

import AncapLibrary.Player.PacketReceiveable;

public class AncapPacket {

    private Sendable[] sendables;

    public void sendTo(PacketReceiveable packetReceiveable) {
        for (Sendable sendable : this.sendables) {
            sendable.sendTo(packetReceiveable);
        }
    }
}
