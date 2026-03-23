package creational.factoryMethod.client;

import creational.factoryMethod.Payment;
import creational.factoryMethod.PaymentMethod;
import creational.factoryMethod.PaymentStatus;

import java.util.UUID;

public class VisaPaymentMethod implements PaymentMethod {

    @Override
    public Payment charge(UUID customerId, double amount) {
        return new Payment(
                customerId,
                amount,
                PaymentStatus.SUCCESS
        );
    }
}
