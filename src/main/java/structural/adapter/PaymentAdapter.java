package structural.adapter;

import java.math.BigDecimal;

public class PaymentAdapter implements PaymentService{
    private final OldPaymentSystem oldPaymentSystem;

    public PaymentAdapter(OldPaymentSystem oldPaymentSystem) {
        this.oldPaymentSystem = oldPaymentSystem;
    }

    @Override
    public void process(Integer cardNumber, BigDecimal amount) {
        var cardNumberString = cardNumber.toString();
        var amountDouble = amount.doubleValue();
        oldPaymentSystem.makePayment(cardNumberString, amountDouble);
    }
}
