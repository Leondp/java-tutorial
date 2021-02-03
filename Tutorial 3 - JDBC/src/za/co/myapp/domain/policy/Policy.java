package za.co.myapp.domain.policy;

import java.math.BigDecimal;

public interface Policy {
    String getPolicyAlpha();
    int getPolicyNumber();
    String getDescription();
    BigDecimal getPremium();
}
