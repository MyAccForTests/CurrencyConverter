package requesters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ilua on 13.12.2016.
 */
public class FixerioRequester extends AbstractRequester{
    //request format: "http://api.fixer.io/2000-01-01?base=USD"
    private String urlTemplateFirst ="http://api.fixer.io/";
    private String urlTemplateSecond="?base=USD";
    //if empty constructor-requesting for today
    public FixerioRequester() {}
    //requesting from dates from fromDate to today
    public FixerioRequester(Calendar fromDate) {
        super(fromDate);
    }
    //requesting from dates from fromDate to toDate
    public FixerioRequester(Calendar fromDate, Calendar toDate) {
        super(fromDate, toDate);
    }
    //abstract method realisation
    public List<model.entities.Currency> getCurrencies()
    {
        RestTemplate restTemplate = new RestTemplate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<String, model.entities.Currency> tempResult = new HashMap<String, model.entities.Currency>();
        while (getFromDate().compareTo(getToDate()) <= 0) {
            StringBuilder url = new StringBuilder(urlTemplateFirst);
            url.append(sdf.format(getFromDate().getTime()));
            url.append(urlTemplateSecond);
            URI finalUrl = URI.create(url.toString());
            IncomingResponse incomingResponse = restTemplate.getForObject(finalUrl, IncomingResponse.class);
            addCurrencyToList(tempResult, incomingResponse);
            getFromDate().add(Calendar.DATE, 1);
        }
        return new ArrayList<model.entities.Currency>(tempResult.values());
    }
    //some helping methods
    private void addCurrencyToList(HashMap<String, model.entities.Currency> map, IncomingResponse incomingResponse)
    {
        for(Map.Entry<String,Double> entry:incomingResponse.getRates().entrySet())
        {
            if(!map.containsKey(entry.getKey()))
            {
                map.put(entry.getKey(),new model.entities.Currency(entry.getKey(),new HashMap<Calendar, Double>()));
            }
            Calendar date=Calendar.getInstance();
            date.setTime(incomingResponse.getDate());
            map.get(entry.getKey()).getValues().put(date,entry.getValue());
        }
    }
    //inner class for data from Fixer.io
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class IncomingResponse
    {
        private String base;
        private Date date;
        private HashMap<String, Double> rates;

        private IncomingResponse() {
        }

        private String getBase() {
            return base;
        }

        private void setBase(String base) {
            this.base = base;
        }

        private Date getDate() {
            return date;
        }

        private void setDate(Date date) {
            this.date = date;
        }

        private HashMap<String, Double> getRates() {
            return rates;
        }

        private void setRates(HashMap<String, Double> rates) {
            this.rates = rates;
        }
    }
}
