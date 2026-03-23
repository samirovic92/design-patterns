package creational.singleton;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import creational.singleton.problem.CurrencyConverter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase_SingletonProblemTest {

    @ParameterizedTest
    @CsvSource({
            "EURO, MAD, 50, 550.0",
            "EURO, USD, 100, 80.0",
            "USD, MAD, 10, 100.0"
    })
    public void convert_money_from_base_currency_to_current_currency(String baseCurrency, String currentCurrency, double amount, double expectedAmount) throws InterruptedException {
        // Given
        var startTime = System.currentTimeMillis();
        CurrencyConverter currencyConverter = new CurrencyConverter();

        // When
        var resultAmount = currencyConverter.convert(baseCurrency, currentCurrency, amount);

        // Then
        var executionTime = System.currentTimeMillis() - startTime;
        assertEquals(expectedAmount, resultAmount);
        assertTrue(executionTime >= 2000);
    }

}
