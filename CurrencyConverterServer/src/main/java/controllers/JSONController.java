package controllers;

import model.entities.Course;
import model.services.CourseDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ilua on 11.01.2017.
 */
@Controller
public class JSONController {

    @Autowired
    private CourseDAOService service;

    @GetMapping(value = "fromDate={fromDate}&toDate={toDate}")
    @ResponseBody
    public ResponseObject fromDateToDate(@PathVariable("fromDate") String from, @PathVariable("toDate") String to)
    {
        Calendar fromDate=parseRequest(from);
        Calendar toDate=parseRequest(to);
        List<Course> courses=service.getCourses(fromDate,toDate);
        return toResponseObject(courses);
    }

    @GetMapping(value = "/onDate={onDate}")
    @ResponseBody
    public ResponseObject onDate(@PathVariable("onDate") String on)
    {
        Calendar onDate=parseRequest(on);
        List<Course> courses=service.getCourses(onDate,onDate);
        return toResponseObject(courses);
    }

    @GetMapping(value = "/latest")
    @ResponseBody
    public ResponseObject latest()
    {
        Calendar today=Calendar.getInstance();
        List<Course> courses=service.getCourses(today);
        return toResponseObject(courses);
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="wrong incoming request")  // 404
    private class WrongDateException extends RuntimeException
    {
        public WrongDateException(String message) {
            super(message);
        }
    }

    private Calendar parseRequest(String string)
    {
        Calendar result=Calendar.getInstance();
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            result.setTime(sdf.parse(string));
        }
        catch (ParseException e) {
            throw new WrongDateException("wrong incoming date");
        }
        return result;
    }

    private ResponseObject toResponseObject(List<Course> courses)
    {
        ResponseObject responseObject=new ResponseObject();
        HashMap<String, List<CurrencyValue>> values=new HashMap<>();
        for(Course temp:courses)
        {
            String date=calendarToString(temp.getDate());
            if(!values.containsKey(date))
            {
                values.put(date,new ArrayList<CurrencyValue>());

            }
            values.get(date).add(new CurrencyValue(temp.getCurrency().getAbbreviation(),temp.getCourse()));
        }
        responseObject.setValues(values);
        return responseObject;
    }

    private String calendarToString(Calendar date)
    {
        StringBuilder builder=new StringBuilder();
        builder.append(date.get(Calendar.DATE));
        builder.append("-");
        builder.append(date.get(Calendar.MONTH)+1);
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
