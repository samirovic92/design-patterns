package creational.singleton;

import shared.ExchangeRate;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.*;

public class CurrencyConverter {
    private static CurrencyConverter instance;
    private List<ExchangeRate> exchangeRates;

    private  CurrencyConverter() throws InterruptedException {
        loadExchangeRate();
    }

    public static synchronized CurrencyConverter getInstance() throws InterruptedException {
        if(isNull(instance)) {
            instance = new CurrencyConverter();
        }
        return  instance;
    }

    private void loadExchangeRate() throws InterruptedException {
        Thread.sleep(2000);
        this.exchangeRates = List.of(
                new shared.ExchangeRate("EURO", "MAD", 11d),
                new shared.ExchangeRate("EURO", "USD", 0.8d),
                new shared.ExchangeRate("USD", "MAD", 10d)
        );
    }

    public double convert(String baseCurrency, String currentCurrency, double amount) {
        var exchangeRate = exchangeRates.stream()
                .filter(r -> r.baseCurrency().equals(baseCurrency) && r.currentCurrency().equals(currentCurrency))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Exchange rate not found"));
        return amount * exchangeRate.rate();
    }

}
