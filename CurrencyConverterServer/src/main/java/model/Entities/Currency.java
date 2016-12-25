package model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Ilua on 12.12.2016.
 */
@Entity
@Table(name = "currencies")
public class Currency implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "Abbreviation")
    private String abbreviation;

    @ElementCollection(fetch = FetchType.LAZY)
    @OneToMany
    @CollectionTable(name = "values", joinColumns = @JoinColumn(name = "CurrencyID"))
    //@Temporal(TemporalType.DATE)
    @MapKeyColumn(name = "Date" )
    @Column(name = "value")
    private HashMap<Calendar, Double> values;

    private static final long serialVersionUID = 0000000000001L;

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
