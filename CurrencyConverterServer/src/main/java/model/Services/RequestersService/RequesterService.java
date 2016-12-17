package model.Services.RequestersService;

import Requesters.CurrencyRequester;
import model.Entities.Currency;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 15.12.2016.
 */
public class RequesterService implements CurrencyRequester {

    private CurrencyRequester service;

    public RequesterService(CurrencyRequester service) {
        this.service = service;
    }

    @Override
    public List<Currency> getCurrencies() {
        return service.getCurrencies();
    }

    @Override
    public Calendar getFromDate() {
        return service.getFromDate();
    }

    @Override
    public Calendar getToDate() {
        return service.getToDate();
    }

    @Override
    public void setFromDate(Calendar fromDate) {
        service.setFromDate(fromDate);
    }

    @Override
    public void setToDate(Calendar toDate) {
        service.setToDate(toDate);
    }
}
