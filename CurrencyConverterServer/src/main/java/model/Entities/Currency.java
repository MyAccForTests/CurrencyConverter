package model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Ilua on 12.12.2016.
 */
@Entity
@Table(name = "currencies")
public class Currency implements Serializable {

    private static final long serialVersionUID = 2000000000000L;

    public Currency(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getId() {
        return id;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Abbreviation")
    private String abbreviation;

    public Currency() {
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
    public static class CurrencySingletonFactory
    {
        private static HashMap<String,Currency> holder=new HashMap<>();

        public static Currency getCurrency(String abbreviation)
        {
            if(!holder.containsKey(abbreviation))
            {
                holder.put(abbreviation,new Currency(abbreviation));
            }
            return holder.get(abbreviation);
        }
    }
}
