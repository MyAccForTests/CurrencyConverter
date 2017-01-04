package model.services;

import dao.CurrencyDAO;
import model.entities.Course;
import model.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 15.12.2016.
 */
@Service("dbService")
@Transactional
public class CurrencyDBServiceImpl implements CurrencyDAOService {

    @Autowired
    private CurrencyDAO service;

    public CurrencyDBServiceImpl() {
    }

    public CurrencyDBServiceImpl(CurrencyDAO service) {
        this.service = service;
    }

    @Override
    public void updateCurrency(Currency currency) {
        service.updateCurrency(currency);
    }

    @Override
    public void updateCurrencies(List<Currency> currencies) {
        service.updateCurrencies(currencies);
    }

    @Override
    public Currency getCurrency(String abbreviation) {
        return service.getCurrency(abbreviation);
    }

    @Override
    public List<Currency> getCurrencies() {
        return service.getCurrencies();
    }

    @Override
    public void updateCourses(List<Course> list) {
        service.updateCourses(list);
    }

    @Override
    public Course getCourse(Calendar onDate, String abbreviation) {
        return service.getCourse(onDate,abbreviation);
    }

    @Override
    public List<Course> getCourses() {
        return service.getCourses();
    }

    @Override
    public List<Course> getCourses(Calendar fromDate) {
        return service.getCourses(fromDate);
    }

    @Override
    public List<Course> getCourses(Calendar fromDate, Calendar toDate) {
        return service.getCourses(fromDate, toDate);
    }
}
