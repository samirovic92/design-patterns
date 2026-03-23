package creational.factoryMethod;

import creational.factoryMethod.client.PaypalPaymentProcessor;
import creational.factoryMethod.client.VisaPaymentProcessor;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static creational.factoryMethod.PaymentStatus.SUCCESS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase_FactoryMethodTest {

    @Test
    public void process_payment_with_visa() {
        // Given
        var customerId = UUID.randomUUID();
        var amount = 1200d;
        var visaPymentProcessor = new VisaPaymentProcessor();
        var expectedPayment = new Payment(customerId, 1200d, SUCCESS);

        // When
        var payment = visaPymentProcessor.processPayment(customerId, amount);

        // Then
        assertEquals(payment, expectedPayment);
    }

    @Test
    public void process_payment_with_paypal() {
        // Given
        var customerId = UUID.randomUUID();
        var amount = 1200d;
        var paypalPaymentProcessor = new PaypalPaymentProcessor();
        var expectedPayment = new Payment(customerId, 1224d, SUCCESS);

        // When
        var payment = paypalPaymentProcessor.processPayment(customerId, amount);

        // Then
        assertEquals(payment, expectedPayment);
    }
}
