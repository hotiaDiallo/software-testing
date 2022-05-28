package com.selftaugh.testing.payment.stripe;

import com.selftaugh.testing.payment.CardPaymentCharge;
import com.selftaugh.testing.payment.CardPaymentCharger;
import com.selftaugh.testing.payment.Currency;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@ConditionalOnProperty(
        value = "stripe.enabled",
        havingValue = "false"
)
public class MockStripeService implements CardPaymentCharger {

    @Override
    public CardPaymentCharge chargeCard(String cardSource, BigDecimal amount, Currency currency, String description) {
        return new CardPaymentCharge(true);
    }
}
