package shared;

public record ExchangeRate(
        String baseCurrency,
        String currentCurrency,
        Double rate
) {
}
