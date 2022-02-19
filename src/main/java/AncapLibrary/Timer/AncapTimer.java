package AncapLibrary.Timer;

import AncapLibrary.Library.AncapLibrary;

public class AncapTimer {

    public void startTimers() {
        AncapLibrary.registerEventsListener(new AncapTimerEventListener());
    }
}
