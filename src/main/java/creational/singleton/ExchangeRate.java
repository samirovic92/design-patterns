package creational.singleton;

public record ExchangeRate(
        String baseCurrency,
        String currentCurrency,
        Double rate
) {
}
