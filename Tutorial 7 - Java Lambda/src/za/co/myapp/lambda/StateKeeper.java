package za.co.myapp.lambda;

import za.co.myapp.domain.State;
import za.co.myapp.eventlistener.StateChangeListener;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StateKeeper {
    private State currentState;
    private List<Consumer<State>> stateChangeListenerList = new ArrayList<>();


    public void doWork() {
        fireStateChange(State.BUSY);
        //do some work
        fireStateChange(State.COMPLETED);
    }

    private void fireStateChange(State state) {
        this.currentState = state;
        for (Consumer<State> consumer : stateChangeListenerList) {
            consumer.accept(state);
        }
    }

    public void addStateListener(Consumer<State> consumer) {
        if (consumer == null) throw new IllegalArgumentException("Instance of Consumer<State> cannot be null");
        stateChangeListenerList.add(consumer);
    }


}
