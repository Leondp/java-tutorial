package za.co.myapp.lambda;

import za.co.myapp.domain.State;

import java.util.function.Consumer;

public class StateChangeLambdaExample1 {

    Consumer<State> consumer = new Consumer<State>() {
        @Override
        public void accept(State state) {
            System.out.println("State is now: " + state);
        }
    };
    
    public void execute() {
        StateKeeper stateKeeper = new StateKeeper();
        stateKeeper.addStateListener(consumer);
        stateKeeper.doWork();
    }

}
