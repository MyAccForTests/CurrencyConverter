package model.Requesters;

import dao.Currency;

import java.util.List;

/**
 * Created by Ilua on 13.12.2016.
 */
public interface CurrencyRequester {
    List<Currency> getCurrencies();
}
