package za.co.myapp.domain.policy;

import za.co.myapp.domain.calculator.PremiumCalculator;

import java.math.BigDecimal;

public abstract class AbstractPolicy implements Policy {
    private final String policyAlpha;
    private final int policyNumber;
    private PremiumCalculator premiumCalculator;

    public AbstractPolicy(String policyAlpha, int policyNumber) {
        this.policyAlpha = policyAlpha;
        this.policyNumber = policyNumber;
    }

    @Override
    public abstract String getDescription();

    @Override
    public BigDecimal getPremium() {
        return premiumCalculator.calculatePremium();
    }

    @Override
    public String getPolicyAlpha() {
        return policyAlpha;
    }

    @Override
    public int getPolicyNumber() {
        return policyNumber;
    }

    public PremiumCalculator getPremiumCalculator() {
        return premiumCalculator;
    }

    public void setPremiumCalculator(PremiumCalculator premiumCalculator) {
        this.premiumCalculator = premiumCalculator;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDescription());
        sb.append(" (");
        sb.append(getPolicyAlpha());
        sb.append(getPolicyNumber());
        sb.append(") ");
        sb.append("- Premium:");
        sb.append(getPremium());
        return sb.toString();
    }
}
