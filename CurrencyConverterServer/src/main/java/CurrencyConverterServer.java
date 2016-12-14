import dao.Currency;
import model.Requesters.CurrencyRequester;
import model.Requesters.FixerioRequester;
import model.Requesters.OpenexchangerateRequester;
import model.Sevices.CurrencyCRUDService;
import model.Sevices.CurrencyMySQLService;

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
        CurrencyCRUDService service=new CurrencyMySQLService();
        System.out.println(service.getCurrencies());
        /*
        //Please initialize the log4j system properly.//time-decision
        org.apache.log4j.BasicConfigurator.configure();
        //

        //stable
        Calendar ago=Calendar.getInstance();
        ago.add(Calendar.DATE,-2);
        Calendar now=Calendar.getInstance();
        CurrencyRequester req=new OpenexchangerateRequester(ago,now);
        List<Currency> list =req.getCurrencies();
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
        //
        */
    }
}
