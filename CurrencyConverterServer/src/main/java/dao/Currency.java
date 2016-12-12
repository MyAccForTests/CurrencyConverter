package dao;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Ilua on 12.12.2016.
 */
public class Currency {
    private String name;
    private HashMap<Date, Double> values;

    public Currency(String name, HashMap<Date, Double> values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public HashMap<Date, Double> getValues() {
        return values;
    }
}
