import org.apache.log4j.BasicConfigurator;
import settings.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;


/**
 * Created by Ilua on 13.12.2016.
 */

public class CurrencyConverterServer {
    private static Properties prop = new Properties();

    public static void main(String[] args) {
        //Please initialize the log4j system properly.//time-decision
        BasicConfigurator.configure();
        //
        loadProperties();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfiguration.class);
        context.getEnvironment().setActiveProfiles(String.valueOf(prop.get("server.database")), String.valueOf(prop.get("server.requester")));
        context.refresh();

        //CourseRequesterService requesterService = (CourseRequesterService) context.getBean("requesterService");

        //CourseDAOService courseDAOService = (CourseDAOService) context.getBean("dbService");

        //CourseScheduleUpdaterService upd= (CourseScheduleUpdaterService) context.getBean("updateService");

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

    private static void loadProperties() {
        try (FileInputStream input = new FileInputStream("src/main/resources/server.properties")) {
            prop.load(input);
        } catch (IOException e) {
            prop.put("server.database", "MySQL");
            prop.put("server.requester", "FixerIO");
            try (OutputStream output = new FileOutputStream("src/main/resources/server.properties")) {
                prop.store(output, null);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private enum Beans
    {
        DB_SERVICE("dbService"),
        REQUESTER_SERVICE("requesterService"),
        UPDATER_SERVICE("updateService");

        private String text;

        Beans(String text)
        {
            this.text=text;
        }

        public String getBeanName() {
            return text;
        }
    }

}
