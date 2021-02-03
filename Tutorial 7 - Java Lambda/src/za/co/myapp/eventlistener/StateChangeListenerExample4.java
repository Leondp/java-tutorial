package za.co.myapp.eventlistener;

public class StateChangeListenerExample4 {

    public void execute() {
        StateKeeper stateKeeper = new StateKeeper();
        stateKeeper.addStateListener(state -> System.out.println("State is now: " + state));
        stateKeeper.doWork();
    }

}