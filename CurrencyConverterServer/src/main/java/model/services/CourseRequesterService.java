package model.services;

import model.entities.Course;
import requesterDAO.CourseRequester;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 13.12.2016.
 */
public interface CourseRequesterService {
    List<Course> getCourses();
    List<Course> getCourses(Calendar fromDate);
    List<Course> getCourses(Calendar fromDate, Calendar toDate);
    CourseRequester getService();
    void setService(CourseRequester courseRequester);
}
