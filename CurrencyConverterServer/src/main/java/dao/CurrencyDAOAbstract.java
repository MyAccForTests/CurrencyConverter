package dao;

import model.entities.Currency;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 15.12.2016.
 */
public abstract class CurrencyDAOAbstract implements CurrencyDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public CurrencyDAOAbstract() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void add(List<Currency> list) {}

    @Override
    public void update(List<Currency> list) {}

    @Override
    public List<Currency> getCurrencies() {
        return null;
    }

    @Override
    public List<Currency> getCurrencies(Calendar fromDate) {
        return null;
    }

    @Override
    public List<Currency> getCurrencies(Calendar fromDate, Calendar toDate) {
        return null;
    }
}
