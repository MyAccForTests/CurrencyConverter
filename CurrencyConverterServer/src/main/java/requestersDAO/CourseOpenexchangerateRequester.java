package requestersDAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import model.entities.Course;
import model.entities.Currency;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ilua on 13.12.2016.
 */
@Repository("CurrencyOpenExchangeRate")
public class CourseOpenexchangerateRequester extends CourseRequesterAbstract {
    //request format: "https://openexchangerates.org/api/historical/2001-02-16.json?app_id=YOUR_APP_APP_ID"
    private String urlTemplateFirst = "https://openexchangerates.org/api/historical/";
    private String appID = "f437a02f7306440a813e8d277a75bb9c";
    private String urlTemplateSecond = ".json?app_id=" + appID;

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
    private List<Course> getCoursesLocal(Calendar fromDate, Calendar toDate)
    {
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
            list.add(new Course(map.getValue(), date, new Currency(map.getKey())));
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