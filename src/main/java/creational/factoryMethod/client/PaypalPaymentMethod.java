package creational.factoryMethod.client;

import creational.factoryMethod.Payment;
import creational.factoryMethod.PaymentMethod;
import creational.factoryMethod.PaymentStatus;

import java.util.UUID;

public class PaypalPaymentMethod implements PaymentMethod {

    @Override
    public Payment charge(UUID customerId, double amount) {
        var chargedAmount = amount * 1.02;
        return new Payment(
                customerId,
                chargedAmount,
                PaymentStatus.SUCCESS
        );
    }
}
