package requesters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import model.entities.Currency;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ilua on 13.12.2016.
 */
/*
@Repository("CurrencyOpenExchangeRate")
public class CurrencyOpenexchangerateRequester extends CurrencyRequesterAbstract {
    //request format: "https://openexchangerates.org/api/historical/2001-02-16.json?app_id=YOUR_APP_APP_ID"
    private String urlTemplateFirst ="https://openexchangerates.org/api/historical/";
    private String appID="f437a02f7306440a813e8d277a75bb9c";
    private String urlTemplateSecond=".json?app_id="+appID;

    //if empty constructor-requesting for today
    public CurrencyOpenexchangerateRequester() {}
    //requesting from dates from fromDate to today
    public CurrencyOpenexchangerateRequester(Calendar fromDate) {
        super(fromDate);
    }
    //requesting from dates from fromDate to toDate
    public CurrencyOpenexchangerateRequester(Calendar fromDate, Calendar toDate) {
        super(fromDate, toDate);
    }
    //abstract method realisation
    public List<Currency> getCurrencies()
    {
        RestTemplate restTemplate = new RestTemplate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<String, Currency> tempResult = new HashMap<String, Currency>();
        while (getFromDate().compareTo(getToDate()) <= 0) {
            StringBuilder url = new StringBuilder(urlTemplateFirst);
            url.append(sdf.format(getFromDate().getTime()));
            url.append(urlTemplateSecond);
            URI finalUrl = URI.create(url.toString());
            IncomingResponse incomingResponse = restTemplate.getForObject(finalUrl, IncomingResponse.class);
            addCurrencyToList(tempResult, incomingResponse);
            getFromDate().add(Calendar.DATE, 1);
        }
        return new ArrayList<Currency>(tempResult.values());
    }
    //some helping methods
    private void addCurrencyToList(HashMap<String, Currency> map, IncomingResponse incomingResponse)
    {
        for(Map.Entry<String,Double> entry:incomingResponse.getRates().entrySet())
        {
            if(!map.containsKey(entry.getKey()))
            {
                map.put(entry.getKey(),new model.entities.Currency(entry.getKey(),new HashMap<Calendar, Double>()));
            }
            Calendar date=Calendar.getInstance();
            date.setTime(new Date(incomingResponse.getTimestamp().getTime()*1000));
            map.get(entry.getKey()).getValues().put(date,entry.getValue());
        }
    }
    //inner class for data from OpenExchangeRates.org
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class IncomingResponse
    {
        //private String disclaimer;
        //private String license;
        private Date timestamp;
        private String base;
        private HashMap<String, Double> rates;

        private IncomingResponse() {
        }

        private String getBase() {
            return base;
        }

        private void setBase(String base) {
            this.base = base;
        }

        private Date getTimestamp() {
            return timestamp;
        }

        private void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

        private HashMap<String, Double> getRates() {
            return rates;
        }

        private void setRates(HashMap<String, Double> rates) {
            this.rates = rates;
        }
    }
}
*/