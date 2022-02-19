package AncapLibrary.Timer.Heartbeat.Exceptions;

public class AncapHeartbeatAlreadyStartedException extends RuntimeException {
    public AncapHeartbeatAlreadyStartedException(String message) {
        super(message);
    }
}
