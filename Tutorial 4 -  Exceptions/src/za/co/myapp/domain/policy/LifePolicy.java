package za.co.myapp.domain.policy;

public class LifePolicy extends AbstractPolicy {

    public LifePolicy(String policyAlpha, int policyNumber) {
        super(policyAlpha, policyNumber);
    }

    @Override
    public String getDescription() {
        return "Life Cover Policy";
    }

}
