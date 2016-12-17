package model.Services.DAOSevice;

import dao.CurrencyDAO;
import model.Entities.Currency;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 15.12.2016.
 */
public class CurrencyService implements CurrencyDAO {

    private CurrencyDAO service;

    public CurrencyService(CurrencyDAO service) {
        this.service = service;
    }

    @Override
    public void add(List<Currency> list) {
        service.add(list);
    }

    @Override
    public void update(List<Currency> list) {
        service.update(list);
    }

    @Override
    public List<Currency> getCurrencies() {
        return service.getCurrencies();
    }

    @Override
    public List<Currency> getCurrencies(Calendar fromDate) {
        return service.getCurrencies(fromDate);
    }

    @Override
    public List<Currency> getCurrencies(Calendar fromDate, Calendar toDate) {
        return service.getCurrencies(fromDate, toDate);
    }
}
