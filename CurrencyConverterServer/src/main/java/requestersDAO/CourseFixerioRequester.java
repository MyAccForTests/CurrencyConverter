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

@Repository("FixerIO")
public class CourseFixerioRequester extends CourseRequesterAbstract {
    //request format: "http://api.fixer.io/2000-01-01?base=USD"
    private String urlTemplateFirst = "http://api.fixer.io/";
    private String urlTemplateSecond = "?base=USD";

    public CourseFixerioRequester() {
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
            date.setTime(incomingResponse.getDate());
            list.add(new Course(map.getValue(), date, new Currency(map.getKey())));
        }
    }

    //inner class for data from Fixer.io
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class IncomingResponse {
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
