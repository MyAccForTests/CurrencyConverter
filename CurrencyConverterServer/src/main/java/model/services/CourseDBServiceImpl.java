package model.services;

import databaseDAO.CourseDAO;
import model.entities.Course;
import model.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 15.12.2016.
 */

@Service("dbService")
@Transactional
public class CourseDBServiceImpl implements CourseDAOService {

    @Autowired
    private CourseDAO service;

    public CourseDBServiceImpl() {
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
    public void updateCourse(Course course) {
        service.updateCourse(course);
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
        return service.getCourses(fromDate,toDate);
    }

    @Override
    public CourseDAO getService() {
        return service;
    }

    @Override
    public void setService(CourseDAO courseDAOService) {
        service=courseDAOService;
    }
}
