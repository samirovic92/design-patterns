package behavioral.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase_StrategyTest {
    InvoiceService invoiceService;

    @BeforeEach
    public void setUp() {
        invoiceService = new InvoiceService();
    }

    @ParameterizedTest
    @CsvSource({
            "NEW, 20",
            "SILVER, 18",
            "GOLD, 10"
    })
    public void calculate_invoice_total_price(CustomerType customerType, double expectedTotalPrice) {
        // Given
        var customerId = UUID.randomUUID();
        var invoice = new Invoice(
                new Customer(customerId, "Alice Persona", customerType),
                List.of(
                        new InvoiceItem(2, 10)
                )
        );

        // When
        var totalPrice = invoiceService.calculateTotal(invoice);

        // Then
        assertEquals(totalPrice, expectedTotalPrice);
    }
}
