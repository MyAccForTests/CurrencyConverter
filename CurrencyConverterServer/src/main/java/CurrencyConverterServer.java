import settings.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        CurrencyRequesterService controller= context.getBean(CurrencyRequesterService.class);
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
        CurrencyDAO service=new CurrencyDAOMySQL();
        System.out.println(service.getCurrencies());
        */
    }
}
