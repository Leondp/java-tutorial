package za.co.myapp.domain.calculator;

import za.co.myapp.domain.client.Client;
import za.co.myapp.domain.policy.DisabilityPolicy;

import java.math.BigDecimal;

public class DisabilityPremiumCalculator implements PremiumCalculator {

    private DisabilityPolicy disabilityPolicy;

    public DisabilityPremiumCalculator(DisabilityPolicy disabilityPolicy) {
        this.disabilityPolicy = disabilityPolicy;
    }

    @Override
    public BigDecimal calculatePremium() {
        BigDecimal premium = new BigDecimal(40);
        premium = premium.add(disabilityPolicy.hasGuidDogCover() ? new BigDecimal(20) : BigDecimal.ZERO);
        premium = premium.add(disabilityPolicy.hasWheelChairCover() ? new BigDecimal(10) : BigDecimal.ZERO);
        return premium;
    }
}
