package za.co.myapp.eventlistener;

import za.co.myapp.domain.State;

import java.util.ArrayList;
import java.util.List;

public class StateKeeper {
    private State currentState;
    private List<StateChangeListener> stateChangeListenerList = new ArrayList<>();


    public void doWork() {
        fireStateChange(State.BUSY);
        //do some work
        fireStateChange(State.COMPLETED);
    }

    private void fireStateChange(State state) {
        this.currentState = state;
        for (StateChangeListener stateListener : stateChangeListenerList) {
            stateListener.stateChanged(state);
        }
    }

    public void addStateListener(StateChangeListener listener) {
        if (listener == null) throw new IllegalArgumentException("Instance of StateChangeListener cannot be null");
        stateChangeListenerList.add(listener);
    }


}
