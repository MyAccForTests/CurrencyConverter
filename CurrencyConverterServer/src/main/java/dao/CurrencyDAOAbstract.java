package dao;

import model.entities.Course;
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
    public void add(List<Course> list) {}

    @Override
    public void update(List<Course> list) {}

    @Override
    public List<Course> getCourses() {
        return null;
    }

    @Override
    public List<Course> getCourses(Calendar fromDate) {
        return null;
    }

    @Override
    public List<Course> getCourses(Calendar fromDate, Calendar toDate) {
        return null;
    }
}
