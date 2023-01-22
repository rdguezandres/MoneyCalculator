package persistence;

import model.Currency;
import model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate exchangeRateLoader(Currency from, Currency to);
}
