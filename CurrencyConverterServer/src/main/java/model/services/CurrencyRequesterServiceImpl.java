package model.services;

import model.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import requesters.CurrencyRequester;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 15.12.2016.
 */
/*
@Service("requesterService")
public class CurrencyRequesterServiceImpl implements CurrencyRequesterService {

    @Autowired
    @Qualifier("FixerIO")
    private CurrencyRequester service;

    public CurrencyRequesterServiceImpl() {
    }

    public void setService(CurrencyRequester service) {
        this.service = service;
    }

    public CurrencyRequesterServiceImpl(CurrencyRequester service) {
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
*/
