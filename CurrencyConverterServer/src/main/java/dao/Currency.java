package dao;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Ilua on 12.12.2016.
 */
public class Currency {
    private String abbreviation;
    private HashMap<Calendar, Double> values;

    public Currency() {
    }

    public Currency(String abbreviation, String name, HashMap<Calendar, Double> values) {
        this.abbreviation = abbreviation;
        this.values = values;
    }

    public Currency(String abbreviation, HashMap<Calendar, Double> values) {
        this.abbreviation = abbreviation;
        this.values = values;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setValues(HashMap<Calendar, Double> values) {
        this.values = values;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public HashMap<Calendar, Double> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "abbreviation='" + abbreviation + '\'' +
                ", values=" + values +
                '}';
    }
}
