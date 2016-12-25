import dao.CurrencyDAO;
import model.entities.Currency;
import model.services.CurrencyDAOService;
import model.services.CurrencyRequesterService;
import org.apache.log4j.BasicConfigurator;
import requesters.CurrencyRequester;
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

        CurrencyDAOService currencyDAOService = (CurrencyDAOService) context.getBean("dbService");

        List res=currencyDAOService.getCurrencies();
        for(Object s:res)
        {
            System.out.println(s);
        }

        //stable DBrequest




        /*
        //stable Request

        CurrencyRequesterService requesterService = (CurrencyRequesterService) context.getBean("requesterService");
        requesterService.setService((CurrencyRequester) context.getBean("CurrencyOpenExchangeRate"));
        Calendar ago=Calendar.getInstance();
        ago.add(Calendar.DATE,-2);
        Calendar now=Calendar.getInstance();

        requesterService.setFromDate(ago);
        requesterService.setToDate(now);

        List<Currency> list =requesterService.getCurrencies();
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
        /*
        CurrencyDAOService service=new CurrencyDAOMySQL();
        System.out.println(service.getCurrencies());
        */
    }
}
