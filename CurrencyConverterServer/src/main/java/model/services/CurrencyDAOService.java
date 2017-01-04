package model.services;

import model.entities.Course;
import model.entities.Currency;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 14.12.2016.
 */
public interface CurrencyDAOService {
    void updateCurrency(Currency currency);
    void updateCurrencies(List<Currency> currencies);
    Currency getCurrency(String abbreviation);
    List<Currency> getCurrencies();
    void updateCourses(List<Course> list);
    Course getCourse(Calendar onDate,String abbreviation);
    List<Course> getCourses();
    List<Course> getCourses(Calendar fromDate);
    List<Course> getCourses(Calendar fromDate, Calendar toDate);
}
