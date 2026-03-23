package creational.singleton.problem;

import creational.singleton.ExchangeRate;

import java.util.List;

public class CurrencyConverter {
    private List<ExchangeRate> exchangeRates;

    public CurrencyConverter() throws InterruptedException {
        loadExchangeRate();
    }

    private void loadExchangeRate() throws InterruptedException {
        Thread.sleep(2000);

        this.exchangeRates = List.of(
                new ExchangeRate("EURO", "MAD", 11d),
                new ExchangeRate("EURO", "USD", 0.8d),
                new ExchangeRate("USD", "MAD", 10d)
        );
    }
    public double convert(String baseCurrency, String currentCurrency, double amount) {
        ExchangeRate exchangeRate = exchangeRates.stream()
                .filter(r -> r.baseCurrency().equals(baseCurrency) && r.currentCurrency().equals(currentCurrency))
                .findFirst()
                .get();
        return amount * exchangeRate.rate();
    }
}
