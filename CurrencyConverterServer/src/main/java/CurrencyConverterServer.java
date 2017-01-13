import org.apache.log4j.BasicConfigurator;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import settings.SpringConfiguration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.io.*;
import java.util.Properties;


/**
 * Created by Ilua on 13.12.2016.
 */

public class CurrencyConverterServer implements WebApplicationInitializer
{
    private static Properties prop = new Properties();


        @Override
        public void onStartup(ServletContext servletContext) throws ServletException {
            //Please initialize the log4j system properly.//time-decision
            BasicConfigurator.configure();
            //
            loadProperties();
            AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
            context.register(SpringConfiguration.class);
            context.getEnvironment().setActiveProfiles(String.valueOf(prop.get("server.database")), String.valueOf(prop.get("server.requester")));
            context.setServletContext(servletContext);
            context.refresh();
            ServletRegistration.Dynamic servlet = servletContext.addServlet(
                    "dispatcher", new DispatcherServlet(context));
            servlet.setLoadOnStartup(1);
            servlet.addMapping("/");
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

    private enum Beans {
        DB_SERVICE("dbService"),
        REQUESTER_SERVICE("requesterService"),
        UPDATER_SERVICE("updateService");

        private String text;

        Beans(String text) {
            this.text = text;
        }

        public String getBeanName() {
            return text;
        }
    }

/*
    public static void main(String[] args) {
        //Please initialize the log4j system properly.//time-decision
        BasicConfigurator.configure();
        //
        loadProperties();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfiguration.class);
        context.getEnvironment().setActiveProfiles(String.valueOf(prop.get("server.database")), String.valueOf(prop.get("server.requester")));
        context.refresh();

        JSONController jsonController=context.getBean(JSONController.class);
        JSONController.ResponseObject obj=jsonController.onDate("22-011-2015");

        System.out.println(obj.getBase());
        HashMap<String, List<JSONController.CurrencyValue>> values=obj.getValues();
        for(Map.Entry<String, List<JSONController.CurrencyValue>> entry:values.entrySet())
        {
            System.out.println(entry.getKey());
            List<JSONController.CurrencyValue> list=entry.getValue();
            for(JSONController.CurrencyValue temp:list)
            {
                System.out.println(temp.getAbbreviation());
                System.out.println(temp.getValue());
            }
        }
    }
*/
}
