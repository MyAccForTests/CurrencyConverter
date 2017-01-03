package model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Ilua on 12.12.2016.
 */
@Entity
@Table(name = "courses")
public class Course implements Serializable{

    private static final long serialVersionUID = 1000000000000L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Course")
    private Double course;

    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Calendar date;

    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "CurrencyID")
    private Currency currency;
    public Course() {
    }

    public Double getCourse() {
        return course;
    }

    public Calendar getDate() {
        return date;
    }

    public Currency getCurrency() {
        return currency;
    }
}
