package za.co.myapp.eventlistener;

import za.co.myapp.domain.State;

public class StateChangeListenerExample2 {

    public void execute() {
        StateKeeper stateKeeper = new StateKeeper();

        stateKeeper.addStateListener(new StateChangeListener() {
            int stateChangeCount = 0;

            @Override
            public void stateChanged(State state) {
                stateChangeCount++;
                System.out.println("State is now: " + state);
            }

            public int getStateChangeCount() {
                return stateChangeCount;
            }
        });

        stateKeeper.doWork();

//        System.out.println("Number of times the state change: " + listener.getStateChangeCount());

    }

}