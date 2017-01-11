package model.services;

import model.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import requesterDAO.CourseRequester;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 15.12.2016.
 */
@Service("requesterService")
public class CourseRequesterServiceImpl implements CourseRequesterService {

    @Autowired
    private CourseRequester service;

    public CourseRequesterServiceImpl() {
    }

    public void setService(CourseRequester service) {
        this.service = service;
    }

    public CourseRequesterServiceImpl(CourseRequester service) {
        this.service = service;
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
    public CourseRequester getService() {
        return service;
    }
}
