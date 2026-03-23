package creational.factoryMethod;

import java.util.UUID;

public record Payment(
    UUID customerId,
    double chargedAmount,
    PaymentStatus status
) {
}
