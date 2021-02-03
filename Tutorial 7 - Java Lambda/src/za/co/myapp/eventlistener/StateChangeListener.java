package za.co.myapp.eventlistener;

import za.co.myapp.domain.State;

@FunctionalInterface
public interface StateChangeListener {
    void stateChanged(State state);
}
