package creational.factoryMethod;

import java.util.UUID;

public abstract class PaymentProcessor {

    public Payment processPayment(UUID customerId, double amount) {
        var paymentMethod = createPaymentMethod();
        return paymentMethod.charge(customerId, amount);
    }

    protected abstract PaymentMethod createPaymentMethod();
}
