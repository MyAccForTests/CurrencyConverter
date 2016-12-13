package dao;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Ilua on 12.12.2016.
 */
public class Currency {
    private String name;
    private HashMap<Calendar, Double> values;

    public Currency() {
    }

    public Currency(String name, HashMap<Calendar, Double> values) {
        this.name = name;
        this.values = values;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValues(HashMap<Calendar, Double> values) {
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public HashMap<Calendar, Double> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", values=" + values +
                '}';
    }
}
