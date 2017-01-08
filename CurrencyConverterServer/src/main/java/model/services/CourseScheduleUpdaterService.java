package model.services;

import model.entities.Course;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 07.01.2017.
 */
public class CourseScheduleUpdaterService {
    private CourseDAOService courseDAOService;
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

    public void update()
    {
        Calendar from=updateToday();
        from.add(Calendar.DATE,-1);
        if(courseDAOService.getCourses(from, from).size()==0) {
            System.out.println("LOG: NULL");
            while (courseDAOService.getCourses(from, from).size()==0) {
                from.add(Calendar.DATE,-1);
                System.out.println("LOG: DATE: "+from.get(Calendar.DATE));
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
        if(courses!=null)
        {
            courseDAOService.updateCourses(courses);
        }
    }
    public void updateAll()
    {
        Calendar from=Calendar.getInstance();
        Calendar to=Calendar.getInstance();
        from.set(2000,00,01);
        updateFromTo(from,to);
    }
}
