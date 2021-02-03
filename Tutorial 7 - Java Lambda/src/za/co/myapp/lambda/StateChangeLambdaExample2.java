package za.co.myapp.lambda;

public class StateChangeLambdaExample2 {

    public void execute() {
        StateKeeper stateKeeper = new StateKeeper();
        stateKeeper.addStateListener(state -> System.out.println("State is now: " + state));
        stateKeeper.doWork();
    }
}
