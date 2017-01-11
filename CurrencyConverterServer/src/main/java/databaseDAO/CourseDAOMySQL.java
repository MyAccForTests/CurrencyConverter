package databaseDAO;

import model.entities.*;
import model.entities.Currency;
import org.hibernate.Session;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * Created by Ilua on 14.12.2016.
 */
@Repository("MySQL")
@Profile("MySQL")
public class CourseDAOMySQL extends CourseDAOAbstract {
    public CourseDAOMySQL() {
    }

    @Override
    public void updateCurrency(Currency currency) {
        Session session = getSessionFactory().getCurrentSession();
        if (currency.getId() != 0 || getCurrency(currency.getAbbreviation()) == null) {
            session.saveOrUpdate(currency);
        }
    }

    @Override
    public void updateCurrencies(List<Currency> currencies) {
        for (Currency currency : currencies) {
            updateCurrency(currency);
        }
    }

    @Override
    public Currency getCurrency(String abbreviation) {
        Session session = getSessionFactory().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Currency> criteriaQuery = criteriaBuilder.createQuery(Currency.class);
        Root<Currency> root = criteriaQuery.from(Currency.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("abbreviation"), abbreviation));
        List<Currency> res = session.createQuery(criteriaQuery).getResultList();
        if (res.size() == 0) {
            return null;
        } else {
            return res.get(0);
        }
    }

    @Override
    public List<Currency> getCurrencies() {
        Session session = getSessionFactory().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Currency> criteriaQuery = criteriaBuilder.createQuery(Currency.class);
        Root<Currency> root = criteriaQuery.from(Currency.class);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void updateCourses(List<Course> list) {
        for (Course course : list) {
            updateCourse(course);
        }
    }

    @Override
    public void updateCourse(Course course) {
        Session session = getSessionFactory().getCurrentSession();
        if (course.getCurrency().getId() == 0) {
            updateCurrency(course.getCurrency());
            course.setCurrency(getCurrency(course.getCurrency().getAbbreviation()));
        }
        if (course.getId() == 0) {
            Course course1 = getCourse(course.getDate(), course.getCurrency().getAbbreviation());
            if (course1 == null) {
                try {
                    session.saveOrUpdate(course);
                }
                catch (Exception e){System.out.println(e);}
            } else {
                course1.setCourse(course.getCourse());
                session.saveOrUpdate(course1);
            }
        } else {
            session.saveOrUpdate(course);
        }
    }

    @Override
    public Course getCourse(Calendar onDate, String abbreviation) {
        Session session = getSessionFactory().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> root = criteriaQuery.from(Course.class);
        Join<Course, Currency> join = root.join("currency");
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.<Calendar>get("date"), onDate), criteriaBuilder.equal(join.get("abbreviation"), abbreviation)));
        List<Course> res = session.createQuery(criteriaQuery).getResultList();
        if (res.size() == 0) {
            return null;
        } else {
            return res.get(0);
        }
    }

    @Override
    public List<Course> getCourses() {
        Session session = getSessionFactory().getCurrentSession();
        //Criteria-based
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> root = criteriaQuery.from(Course.class);
        return session.createQuery(criteriaQuery).getResultList();
        /*
        //HQL-based
        Query query=session.createQuery("FROM Course");
        return query.list();
        */
    }

    @Override
    public List<Course> getCourses(Calendar fromDate) {
        Session session = getSessionFactory().getCurrentSession();
        fromDate.set(Calendar.MINUTE, 01);
        fromDate.set(Calendar.HOUR, 00);
        //Criteria-based
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> root = criteriaQuery.from(Course.class);
        criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(root.<Calendar>get("date"), fromDate));
        return session.createQuery(criteriaQuery).getResultList();
        //HQL-based
        /*
        Query query=session.createQuery("FROM Course cour WHERE cour.date>=:fromDate");
        query.setParameter("fromDate",fromDate);
        return query.list();
        */
    }

    @Override
    public List<Course> getCourses(Calendar fromDate, Calendar toDate) {
        Session session = getSessionFactory().getCurrentSession();
        fromDate.set(Calendar.MINUTE, 01);
        fromDate.set(Calendar.HOUR, 00);
        toDate.set(Calendar.MINUTE, 59);
        toDate.set(Calendar.HOUR_OF_DAY, 23);
        //Criteria-based
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> root = criteriaQuery.from(Course.class);
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.<Calendar>get("date"), fromDate), criteriaBuilder.lessThanOrEqualTo(root.<Calendar>get("date"), toDate)));
        return session.createQuery(criteriaQuery).getResultList();
        //HQL-based
        /*
        Query query=session.createQuery("FROM Course cour WHERE cour.date>=:fromDate AND cour.date<=:toDate");
        query.setParameter("fromDate",fromDate);
        query.setParameter("toDate",toDate);
        return query.list();
        */
    }
}
