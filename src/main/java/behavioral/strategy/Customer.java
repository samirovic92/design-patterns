package behavioral.strategy;

import java.util.UUID;

public record Customer(
        UUID id,
        String fullName,
        CustomerType customerType
) {
}
