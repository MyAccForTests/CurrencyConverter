import model.entities.Course;
import model.services.CourseDAOService;
import model.services.CourseRequesterService;
import model.services.CourseScheduleUpdaterService;
import org.apache.log4j.BasicConfigurator;
import requestersDAO.CourseRequester;
import settings.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;


/**
 * Created by Ilua on 13.12.2016.
 */
public class CurrencyConverterServer {
    public static void main(String[] args) {
        //Please initialize the log4j system properly.//time-decision
        BasicConfigurator.configure();
        //

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfiguration.class);
        context.refresh();

        CourseRequesterService requesterService = (CourseRequesterService) context.getBean("requesterService");
        //requesterService.setService((CourseRequester) context.getBean("CurrencyOpenExchangeRate"));

        //stable DBRequest FromDate
        CourseDAOService courseDAOService = (CourseDAOService) context.getBean("dbService");

        CourseScheduleUpdaterService upd= (CourseScheduleUpdaterService) context.getBean("updateService");
        upd.updateAll();

        /*
        Calendar from = Calendar.getInstance();
        from.set(2016, 11, 30);

        Calendar to = Calendar.getInstance();
        to.set(2017, 00, 07);
        */
        /*
        List<Course> list=courseDAOService.getCourses(from,to);
        for(Course s:list)
        {
            System.out.println(s.getCurrency().getAbbreviation());
            System.out.println(s.getDate().getTime());
            System.out.println(s.getCourse());
        }
        */
        /*
        //stable GETRequest
        List<Course> list =requesterService.getCourses();
        for(Course s:list)
        {
            System.out.println(s.getCurrency().getAbbreviation());
            System.out.println(s.getDate().getTime());
            System.out.println(s.getCourse());
        }
        */
    }
}
