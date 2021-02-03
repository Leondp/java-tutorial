package za.co.myapp.domain.policy;

import za.co.myapp.domain.calculator.DisabilityPremiumCalculator;
import za.co.myapp.domain.calculator.LifePolicyPremiumCalculator;
import za.co.myapp.domain.calculator.PremiumCalculator;
import za.co.myapp.domain.client.Client;

public class PolicyBuilder {

    public static DisabilityPolicyBuilder disablity(String policyAlpha, int policyNumber) {
        return new DisabilityPolicyBuilder(policyAlpha, policyNumber);
    }

    public static LifePolicyBuilder life(String policyAlpha, int policyNumber) {
        return new LifePolicyBuilder(policyAlpha, policyNumber);
    }

    public static class LifePolicyBuilder {
        LifePolicy lifePolicy;
        Client client;

        public LifePolicyBuilder(String policyAlpha, int policyNumber) {
            lifePolicy = new LifePolicy(policyAlpha, policyNumber);
        }

        public LifePolicyBuilder premiumCalculator(PremiumCalculator premiumCalculator) {
            lifePolicy.setPremiumCalculator(premiumCalculator);
            return this;
        }

        public LifePolicyBuilder client(Client client) {
            this.client = client;
            return this;
        }

        public LifePolicy build() {
            if (this.lifePolicy.getPremiumCalculator() == null) {
                LifePolicyPremiumCalculator lifePolicyPremiumCalculator = new LifePolicyPremiumCalculator(client);
                this.lifePolicy.setPremiumCalculator(lifePolicyPremiumCalculator);
            }
            return this.lifePolicy;
        }
    }

    public static class DisabilityPolicyBuilder {
        DisabilityPolicy disabilityPolicy;
        Client client;

        public DisabilityPolicyBuilder(String policyAlpha, int policyNumber) {
            disabilityPolicy = new DisabilityPolicy(policyAlpha, policyNumber);
        }

        public DisabilityPolicyBuilder addTheDog() {
            disabilityPolicy.setGuidDogCover(true);
            return this;
        }

        public DisabilityPolicyBuilder addTheWheelChair() {
            disabilityPolicy.setWheelChairCover(true);
            return this;
        }

        public DisabilityPolicyBuilder premiumCalculator(PremiumCalculator premiumCalculator) {
            disabilityPolicy.setPremiumCalculator(premiumCalculator);
            return this;
        }

        public DisabilityPolicy build() {
            if (this.disabilityPolicy.getPremiumCalculator() == null) {
                DisabilityPremiumCalculator disabilityPremiumCalculator = new DisabilityPremiumCalculator(this.disabilityPolicy);
                this.disabilityPolicy.setPremiumCalculator(disabilityPremiumCalculator);
            }
            return this.disabilityPolicy;
        }

    }

}
