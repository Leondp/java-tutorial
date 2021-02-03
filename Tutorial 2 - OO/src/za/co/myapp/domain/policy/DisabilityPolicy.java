package za.co.myapp.domain.policy;

public class DisabilityPolicy extends AbstractPolicy {

    private boolean wheelChairCover = false;
    private boolean guidDogCover = false;

    public DisabilityPolicy(String policyAlpha, int policyNumber) {
        super(policyAlpha, policyNumber);
    }

    @Override
    public String getDescription() {
        return "Disability Policy";
    }

    public boolean hasWheelChairCover() {
        return wheelChairCover;
    }

    public void setWheelChairCover(boolean wheelChairCover) {
        this.wheelChairCover = wheelChairCover;
    }

    public boolean hasGuidDogCover() {
        return guidDogCover;
    }

    public void setGuidDogCover(boolean guidDogCover) {
        this.guidDogCover = guidDogCover;
    }
}

