package AncapLibrary.Timer.Heartbeat;

import AncapLibrary.Library.AncapLibrary;
import AncapLibrary.Timer.AncapTimer;
import AncapLibrary.Timer.Heartbeat.Exceptions.AncapHeartbeatAlreadyStartedException;

public class AncapHeartbeat {

    private static boolean started = false;

    public void start() {
        if (started) {
            throw new AncapHeartbeatAlreadyStartedException("AncapHeartbeat is already started");
        }
        AncapHeartbeatRunnable runnable = new AncapHeartbeatRunnable();
        runnable.runTaskTimer(AncapLibrary.getInstance(), 0, 20L);
        AncapTimer timer = new AncapTimer();
        timer.startTimers();
        started = true;
    }

}
