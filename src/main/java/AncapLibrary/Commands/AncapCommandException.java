package AncapLibrary.Commands;

import AncapLibrary.Packet.AncapPacket;
import AncapLibrary.Player.PacketReceiveable;

public class AncapCommandException extends Exception {

    private PacketReceiveable packetReceiveable;
    private AncapPacket packet;

    public AncapCommandException(PacketReceiveable packetReceiveable, AncapPacket packet) {
        this.packetReceiveable = packetReceiveable;
        this.packet = packet;
    }

    public void handle() {
        this.packet.sendTo(packetReceiveable);
    }
}
