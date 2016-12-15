import Settings.SpringConfiguration;
import dao.Currency;
import model.Requesters.RequestersController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ilua on 13.12.2016.
 */
public class CurrencyConverterServer {
    public static void main(String[] args)
    {
        //Please initialize the log4j system properly.//time-decision
        org.apache.log4j.BasicConfigurator.configure();
        //

        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);


        /*
        //stable
        RequestersController controller= context.getBean(RequestersController.class);
        Calendar ago=Calendar.getInstance();
        ago.add(Calendar.DATE,-2);
        Calendar now=Calendar.getInstance();

        controller.setFromDate(ago);
        controller.setToDate(now);

        List<Currency> list =controller.getCurrencies();
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
        CurrencyCRUDService service=new CurrencyMySQLService();
        System.out.println(service.getCurrencies());
        */
    }
}
