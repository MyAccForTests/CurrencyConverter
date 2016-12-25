package model.services;

import model.entities.Currency;
import requesters.CurrencyRequester;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 13.12.2016.
 */
public interface CurrencyRequesterService {
    List<Currency> getCurrencies();
    Calendar getFromDate();
    Calendar getToDate();
    void setFromDate(Calendar fromDate);
    void setToDate(Calendar toDate);
    void setService(CurrencyRequester service);
}
