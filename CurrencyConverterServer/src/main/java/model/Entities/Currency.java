package model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ilua on 12.12.2016.
 */
@Entity
@Table(name = "currencies")
public class Currency implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Abbreviation")
    private String abbreviation;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "courses",
            joinColumns = @JoinColumn(name = "CurrencyID")
    )
    @MapKeyTemporal(TemporalType.DATE)
    @MapKeyColumn(name="Date")
    @Column(name = "Course")
    private Map<Calendar, Double> values=new HashMap<>();

    private static final long serialVersionUID = 1000000000000L;

    public Currency() {
    }

    public Currency(String abbreviation, HashMap<Calendar, Double> values) {
        this.abbreviation = abbreviation;
        this.values = values;
    }

    public int getId() {
        return id;
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

    public Map<Calendar, Double> getValues() {
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
