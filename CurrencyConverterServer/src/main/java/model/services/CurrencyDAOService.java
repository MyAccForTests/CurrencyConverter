package model.services;

import model.entities.Course;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 14.12.2016.
 */
public interface CurrencyDAOService {
    void update(List<Course> list);
    void updateAll(List<Course> list);
    List<Course> getCourses();
    List<Course> getCourses(Calendar fromDate);
    List<Course> getCourses(Calendar fromDate, Calendar toDate);
}
