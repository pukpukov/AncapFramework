package AncapLibrary.Packet;

import AncapLibrary.Player.PacketReceiveable;

public interface Sendable {

    void sendTo(PacketReceiveable receiveable);
}
