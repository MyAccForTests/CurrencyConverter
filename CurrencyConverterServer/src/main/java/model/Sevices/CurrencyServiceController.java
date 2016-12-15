package model.Sevices;

import dao.Currency;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 15.12.2016.
 */
public class CurrencyServiceController implements CurrencyCRUDService {

    private CurrencyCRUDService service;

    public CurrencyServiceController(CurrencyCRUDService service) {
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
