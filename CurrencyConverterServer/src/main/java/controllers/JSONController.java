package controllers;

import model.entities.Course;
import model.services.CourseDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by Ilua on 11.01.2017.
 */
@RestController
public class JSONController {

    @Autowired
    private CourseDAOService service;

    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject latest()
    {
        Calendar today=Calendar.getInstance();
        List<Course> courses=service.getCourses();
        return toResponseObject(courses);
    }

    private ResponseObject toResponseObject(List<Course> courses)
    {
        ResponseObject responseObject=new ResponseObject();
        Map<String, List<CurrencyValue>> values=new HashMap<>();
        List<CurrencyValue> list=new ArrayList<>();
        for(Course temp:courses)
        {
            String date=calendarToString(temp.getDate());
            if(!values.containsKey(date))
            {
                values.put(date,list);

            }
            values.get(date).add(new CurrencyValue(temp.getCurrency().getAbbreviation(),temp.getCourse()));
        }
        return responseObject;
    }

    private String calendarToString(Calendar date)
    {
        StringBuilder builder=new StringBuilder();
        builder.append(date.get(Calendar.DATE));
        builder.append("-");
        builder.append(date.get(Calendar.MONTH));
        builder.append("-");
        builder.append(date.get(Calendar.YEAR));
        return builder.toString();
    }

    private class ResponseObject
    {
        private String base="USD";
        private HashMap<String, List<CurrencyValue>> values;

        public ResponseObject() {
        }

        public ResponseObject(String base, HashMap<String, List<CurrencyValue>> values) {
            this.base = base;
            this.values = values;
        }

        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public HashMap<String, List<CurrencyValue>> getValues() {
            return values;
        }

        public void setValues(HashMap<String, List<CurrencyValue>> values) {
            this.values = values;
        }
    }

    private class CurrencyValue
    {
        private String abbreviation;
        private Double value;

        public CurrencyValue() {
        }

        public CurrencyValue(String abbreviation, Double value) {
            this.abbreviation = abbreviation;
            this.value = value;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }
    }
}
