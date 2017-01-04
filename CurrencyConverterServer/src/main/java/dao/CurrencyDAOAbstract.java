package dao;

import model.entities.Course;
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
    public abstract void updateCurrency(Currency currency);

    @Override
    public abstract void updateCurrencies(List<Currency> currencies);

    @Override
    public abstract  Currency getCurrency(String abbreviation);

    @Override
    public abstract List<Currency> getCurrencies();

    @Override
    public abstract void updateCourses(List<Course> list);

    @Override
    public abstract List<Course> getCourses();

    @Override
    public abstract List<Course> getCourses(Calendar fromDate);

    @Override
    public abstract List<Course> getCourses(Calendar fromDate, Calendar toDate);
}
