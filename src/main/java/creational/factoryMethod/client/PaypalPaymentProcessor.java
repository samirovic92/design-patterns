package creational.factoryMethod.client;

import creational.factoryMethod.PaymentMethod;
import creational.factoryMethod.PaymentProcessor;

public class PaypalPaymentProcessor extends PaymentProcessor {

    @Override
    protected PaymentMethod createPaymentMethod() {
        return new PaypalPaymentMethod();
    }
}
