package dao;

import model.Entities.Currency;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 14.12.2016.
 */
public interface CurrencyDAO {
    void add (List<Currency> list);
    void update(List<Currency> list);
    List<Currency> getCurrencies();
    List<Currency> getCurrencies(Calendar fromDate);
    List<Currency> getCurrencies(Calendar fromDate, Calendar toDate);
}
