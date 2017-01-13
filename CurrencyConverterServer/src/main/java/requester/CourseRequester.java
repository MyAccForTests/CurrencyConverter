package requester;

import model.entities.Course;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 13.12.2016.
 */
public interface CourseRequester {
    List<Course> getCourses();
    List<Course> getCourses(Calendar fromDate);
    List<Course> getCourses(Calendar fromDate, Calendar toDate);
}
