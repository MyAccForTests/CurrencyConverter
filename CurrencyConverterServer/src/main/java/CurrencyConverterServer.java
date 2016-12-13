import dao.Currency;
import model.CurrencyRequester;
import model.FixerIORequester;

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

        //stable
        Calendar ago=Calendar.getInstance();
        ago.add(Calendar.DATE,-5);
        Calendar now=Calendar.getInstance();
        CurrencyRequester req=new FixerIORequester(ago,now);
        List<Currency> list =req.getCurrencies();
        //

        //testing
        for(Currency t:list)
        {
            HashMap<Calendar,Double> tt=t.getValues();
            System.out.println("For Currency: "+t.getName());
            for(Map.Entry<Calendar,Double> ttt:tt.entrySet())
            {
                System.out.println("On: "+ttt.getKey().getTime().toString());
                System.out.println("Course is: "+ttt.getValue());
            }
        }
        //
    }
}
