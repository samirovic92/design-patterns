package creational.singleton;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase_SingletonSolutionTest {

    @ParameterizedTest
    @CsvSource({
            "EURO, MAD, 50, 550.0, true",
            "EURO, USD, 100, 80.0, false",
            "USD, MAD, 10, 100.0, false"
    })
    public void convert_money_from_base_currency_to_current_currency(String baseCurrency,
                                                                     String currentCurrency,
                                                                     double amount,
                                                                     double expectedAmount,
                                                                     boolean isCallSlow) throws InterruptedException {
        // Given
        var startTime = System.currentTimeMillis();
        CurrencyConverter currencyConverter = CurrencyConverter.getInstance();

        // When
        var resultAmount = currencyConverter.convert(baseCurrency, currentCurrency, amount);

        // Then
        var executionTime = System.currentTimeMillis() - startTime;
        assertEquals(expectedAmount, resultAmount);
        assertEquals(executionTime >= 2000, isCallSlow);
    }

}
