package requester;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import model.entities.Course;
import model.entities.Currency;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ilua on 13.12.2016.
 */
@Repository("OpenExchangeRate")
@Profile("OpenExchangeRate")
public class CourseOpenexchangerateRequester extends CourseRequesterAbstract {
    //request format: "https://openexchangerates.org/api/historical/2001-02-16.json?app_id=YOUR_APP_APP_ID"
    private String urlTemplateFirst;
    private String appID;
    private String urlTemplateSecond;

    private static Properties prop = new Properties();

    {
        try(FileInputStream input=new FileInputStream("src/main/resources/requester.properties")) {
            prop.load(input);
        } catch (IOException e) {
            prop.put("requester.openexchangerate.baseurl", "https://openexchangerates.org/api/historical/");
            prop.put("requester.openexchangerate.baseurl2",".json?app_id=");
            prop.put("requester.openexchangerate.appID","f437a02f7306440a813e8d277a75bb9c");
            try(OutputStream output = new FileOutputStream("src/main/resources/requester.properties"))
            {
                prop.store(output,null);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        urlTemplateFirst=prop.getProperty("requester.openexchangerate.baseurl");
        appID=prop.getProperty("requester.openexchangerate.appID");
        urlTemplateSecond=prop.getProperty("requester.openexchangerate.baseurl2") + appID;
    }
    public CourseOpenexchangerateRequester() {
    }

    public List<Course> getCourses() {
        Calendar today=Calendar.getInstance();
        Calendar to= (Calendar) today.clone();
        to.add(Calendar.MILLISECOND,100);
        return getCourses(today,to);
    }

    @Override
    public List<Course> getCourses(Calendar fromDate) {
        Calendar today=Calendar.getInstance();
        today.add(Calendar.MILLISECOND,100);
        return getCoursesLocal(fromDate,today);
    }

    @Override
    public List<Course> getCourses(Calendar fromDate, Calendar toDate) {
        toDate.add(Calendar.MILLISECOND,100);
        return getCoursesLocal(fromDate,toDate);
    }

    //some helping methods
    private List<Course> getCoursesLocal(Calendar from, Calendar to)
    {
        Calendar fromDate= (Calendar) from.clone();
        Calendar toDate= (Calendar) to.clone();
        RestTemplate restTemplate = new RestTemplate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Course> result = new ArrayList<>();
        while (fromDate.compareTo(toDate) <= 0) {
            StringBuilder url = new StringBuilder(urlTemplateFirst);
            url.append(sdf.format(fromDate.getTime()));
            url.append(urlTemplateSecond);
            URI finalUrl = URI.create(url.toString());
            try {
                IncomingResponse incomingResponse = restTemplate.getForObject(finalUrl, IncomingResponse.class);
                addCurrencyToList(result, incomingResponse);
            }
            catch (Exception e){}
            fromDate.add(Calendar.DATE, 1);
        }
        return result;
    }

    private void addCurrencyToList(List<Course> list, IncomingResponse incomingResponse) {
        HashMap<String, Double> rates = incomingResponse.getRates();
        for (Map.Entry<String, Double> map : rates.entrySet()) {
            Calendar date = Calendar.getInstance();
            date.setTime(new Date(incomingResponse.getTimestamp().getTime() * 1000));
            list.add(new Course(map.getValue(), date, Currency.CurrencySingletonFactory.getCurrency(map.getKey())));
        }

    }

    //inner class for data from OpenExchangeRates.org
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class IncomingResponse {
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