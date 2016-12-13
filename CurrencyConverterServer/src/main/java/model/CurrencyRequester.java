package model;

import dao.Currency;

import java.util.List;

/**
 * Created by Ilua on 13.12.2016.
 */
public interface CurrencyRequester {
    public List<Currency> getCurrencies();
}
