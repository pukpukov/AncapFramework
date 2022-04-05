package AncapLibrary.Timer.Heartbeat;

import AncapLibrary.Library.AncapLibrary;
import AncapLibrary.Timer.Heartbeat.Exceptions.AncapHeartbeatAlreadyStartedException;

public class AncapHeartbeat {

    private static boolean started = false;

    public void start() {
        this.validateStart();
        this.loadRunnable();
        this.finishLoading();
    }

    private void validateStart() {
        if (started) {
            throw new AncapHeartbeatAlreadyStartedException("AncapHeartbeat is already started");
        }
    }

    private void loadRunnable() {
        AncapHeartbeatRunnable runnable = new AncapHeartbeatRunnable();
        runnable.runTaskTimer(AncapLibrary.getPlugin(), 0, 20L);
    }

    private void finishLoading() {
        started = true;
    }

}
