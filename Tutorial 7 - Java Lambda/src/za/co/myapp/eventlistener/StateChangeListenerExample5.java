package za.co.myapp.eventlistener;

public class StateChangeListenerExample5 {
    private int stateChangeCount = 0;

    public void execute() {
        StateKeeper stateKeeper = new StateKeeper();

        stateKeeper.addStateListener(state -> {
            this.addToStateChangeCounter();
            System.out.println("State is now: " + state);
        });

        stateKeeper.doWork();
        System.out.println("Number of times the state change: " + this.stateChangeCount);
    }

    private void addToStateChangeCounter() {
        this.stateChangeCount++;
    }

}