package creational.factoryMethod.client;

import creational.factoryMethod.PaymentMethod;
import creational.factoryMethod.PaymentProcessor;

public class VisaPaymentProcessor extends PaymentProcessor {

    @Override
    protected PaymentMethod createPaymentMethod() {
        return new VisaPaymentMethod();
    }
}
