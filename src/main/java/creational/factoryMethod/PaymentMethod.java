package creational.factoryMethod;

import java.util.UUID;

public interface PaymentMethod {
    Payment charge(UUID customerId, double amount);
}
