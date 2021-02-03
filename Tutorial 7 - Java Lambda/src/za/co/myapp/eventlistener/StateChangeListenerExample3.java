package za.co.myapp.eventlistener;

import za.co.myapp.domain.State;

public class StateChangeListenerExample3 {

    public void execute() {
        StateKeeper stateKeeper = new StateKeeper();

        StateChangeListener listener = new StateChangeListener() {
            int stateChangeCount = 0;

            @Override
            public void stateChanged(State state) {
                this.stateChangeCount++;
                System.out.println("State is now: " + state);
            }

            public int getStateChangeCount() {
                return stateChangeCount;
            }
        };

        stateKeeper.addStateListener(listener);

        stateKeeper.doWork();

        //System.out.println("Number of times the state change: " + listener.getStateChangeCount());

    }

}