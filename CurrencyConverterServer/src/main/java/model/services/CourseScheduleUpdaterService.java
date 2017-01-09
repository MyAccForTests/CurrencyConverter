package model.services;

import model.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 07.01.2017.
 */
@Service("updateService")
public class CourseScheduleUpdaterService {
    @Autowired
    private CourseDAOService courseDAOService;
    @Autowired
    private CourseRequesterService courseRequesterService;

    public CourseDAOService getCourseDAOService() {
        return courseDAOService;
    }

    public void setCourseDAOService(CourseDAOService courseDAOService) {
        this.courseDAOService = courseDAOService;
    }

    public CourseRequesterService getCourseRequesterService() {
        return courseRequesterService;
    }

    public void setCourseRequesterService(CourseRequesterService courseRequesterService) {
        this.courseRequesterService = courseRequesterService;
    }

    public CourseScheduleUpdaterService() {
    }

    public CourseScheduleUpdaterService(CourseDAOService courseDAOService, CourseRequesterService courseRequesterService) {
        this.courseDAOService = courseDAOService;
        this.courseRequesterService = courseRequesterService;
    }

    public void updateTodayAndVerifyPrevious()
    {
        Calendar from=updateToday();
        from.add(Calendar.DATE,-1);
        if(courseDAOService.getCourses(from, from).size()==0) {
            while (courseDAOService.getCourses(from, from).size()==0) {
                from.add(Calendar.DATE,-1);
            }
            updateFrom(from);
        }
    }

    public Calendar updateToday()
    {
        List<Course> courses=courseRequesterService.getCourses();
        if(courses!=null)
        {
            courseDAOService.updateCourses(courses);
            return courses.get(0).getDate();
        }
        return null;
    }
    public void updateFrom(Calendar fromDate)
    {
        List<Course> courses=courseRequesterService.getCourses(fromDate);
        if(courses!=null)
        {
            courseDAOService.updateCourses(courses);
        }
    }

    public void updateFromTo(Calendar fromDate,Calendar toDate)
    {
            List<Course> courses=courseRequesterService.getCourses(fromDate,toDate);
            if(courses.size()>0)
            {
                courseDAOService.updateCourses(courses);
            }
    }

    public void updateAll()
    {
        final int DATE_STEP=60;
        Calendar from=Calendar.getInstance();
        Calendar today=Calendar.getInstance();
        Calendar to=Calendar.getInstance();
        from.set(2000,00,01,00,01);
        to.set(2000, 00, 01,23,59);
        to.add(Calendar.DATE, DATE_STEP);
        while (from.compareTo(today)<=0) {
            updateFromTo(from, to);
            from.add(Calendar.DATE, DATE_STEP);
            to.add(Calendar.DATE, DATE_STEP);
        }
    }
}
