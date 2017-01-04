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

    public Course(Double course, Calendar date, Currency currency) {
        this.course = course;
        this.date = date;
        this.currency = currency;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Column(name = "Course")
    private Double course;

    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Calendar date;

    @ManyToOne
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course=" + course +
                ", date=" + date +
                ", currency=" + currency +
                '}';
    }
}
