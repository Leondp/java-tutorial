package za.co.myapp.domain.calculator;

import za.co.myapp.domain.client.Client;

import java.math.BigDecimal;

public class LifePolicyPremiumCalculator implements PremiumCalculator {

    private Client client;

    public LifePolicyPremiumCalculator(Client client) {
        this.client = client;
    }

    @Override
    public BigDecimal calculatePremium() {
        BigDecimal premium = new BigDecimal(50);
        premium = premium.add(new BigDecimal(this.client.getAge()));
        premium = premium.add(this.client.isSmoking() ? new BigDecimal(20) : BigDecimal.ZERO);
        return premium;
    }
}
