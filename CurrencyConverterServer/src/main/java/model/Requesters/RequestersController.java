package model.Requesters;

import dao.Currency;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 15.12.2016.
 */
public class RequestersController implements CurrencyRequester {

    private CurrencyRequester controller;

    public RequestersController(CurrencyRequester controller) {
        this.controller = controller;
    }

    @Override
    public List<Currency> getCurrencies() {
        return controller.getCurrencies();
    }

    @Override
    public Calendar getFromDate() {
        return controller.getFromDate();
    }

    @Override
    public Calendar getToDate() {
        return controller.getToDate();
    }

    @Override
    public void setFromDate(Calendar fromDate) {
        controller.setFromDate(fromDate);
    }

    @Override
    public void setToDate(Calendar toDate) {
        controller.setToDate(toDate);
    }
}
