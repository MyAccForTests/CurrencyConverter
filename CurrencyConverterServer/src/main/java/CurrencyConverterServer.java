import model.entities.Course;
import model.services.CurrencyDAOService;
import org.apache.log4j.BasicConfigurator;
import settings.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;


/**
 * Created by Ilua on 13.12.2016.
 */
public class CurrencyConverterServer {
    public static void main(String[] args)
    {
        //Please initialize the log4j system properly.//time-decision
        BasicConfigurator.configure();
        //

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(SpringConfiguration.class);
        context.refresh();

        //CurrencyRequesterService requesterService = (CurrencyRequesterService) context.getBean("requesterService");
        //requesterService.setService((CurrencyRequester) context.getBean("CurrencyOpenExchangeRate"));

        //stable DBRequest FromDate
        CurrencyDAOService currencyDAOService = (CurrencyDAOService) context.getBean("dbService");
        //currencyDAOService.update(requesterService.getCurrency());
        Calendar now=Calendar.getInstance();
        now.set(2016,11,21);

        Calendar to=Calendar.getInstance();
        to.set(2016,11,22);

        List<Course> res=currencyDAOService.getCourses();

        for(Course s:res)
        {
            System.out.println(s.getCurrency().getAbbreviation());
            System.out.println(s.getDate().getTime());
            System.out.println(s.getCourse());
        }






        /*
        //stable DBAdder
        CurrencyDAOService currencyDAOService = (CurrencyDAOService) context.getBean("dbService");
        CurrencyRequesterService requesterService = (CurrencyRequesterService) context.getBean("requesterService");

        Calendar ago=Calendar.getInstance();
        ago.update(Calendar.DATE,-7);
        Calendar now=Calendar.getInstance();

        requesterService.setFromDate(ago);
        requesterService.setToDate(now);

        List<Currency> list =requesterService.getCurrency();

        currencyDAOService.update(list);
        */


        /*
        //stable DBRequest
        CurrencyDAOService currencyDAOService = (CurrencyDAOService) context.getBean("dbService");

        List<Currency> res=currencyDAOService.getCurrency();
        for(Currency s:res)
        {
            System.out.println(s.getAbbreviation());
            Map<Calendar,Double> values=s.getValues();
            for(Map.Entry<Calendar,Double> ttt:values.entrySet())
            {
                System.out.println("On: "+ttt.getKey().getTime().toString());
                System.out.println("Course is: "+ttt.getValue());
            }
        }
        */


        /*
        //stable GETRequest

        CurrencyRequesterService requesterService = (CurrencyRequesterService) context.getBean("requesterService");
        requesterService.setService((CurrencyRequester) context.getBean("CurrencyOpenExchangeRate"));
        Calendar ago=Calendar.getInstance();
        ago.update(Calendar.DATE,-2);
        Calendar now=Calendar.getInstance();

        requesterService.setFromDate(ago);
        requesterService.setToDate(now);

        List<Currency> list =requesterService.getCurrency();
        //

        //testing
        for(Currency t:list)
        {
            HashMap<Calendar,Double> tt=t.getValues();
            System.out.println("Currency: "+t.getAbbreviation());
            for(Map.Entry<Calendar,Double> ttt:tt.entrySet())
            {
                System.out.println("On: "+ttt.getKey().getTime().toString());
                System.out.println("Course is: "+ttt.getValue());
            }
        }

        */
    }
}
