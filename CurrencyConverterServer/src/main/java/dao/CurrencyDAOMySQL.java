package dao;

import model.entities.*;
import model.entities.Currency;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * Created by Ilua on 14.12.2016.
 */
@Repository("MySQL")
public class CurrencyDAOMySQL extends CurrencyDAOAbstract {
    public CurrencyDAOMySQL() {
    }

    public void update(List<Course> list) {
        Session session=getSessionFactory().getCurrentSession();
    }

    public void updateAll(List<Course> list) {
        Session session=getSessionFactory().getCurrentSession();
    }

    public List<Course> getCourses() {
        Session session=getSessionFactory().getCurrentSession();

        //Criteria-based
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery=criteriaBuilder.createQuery(Course.class);
        Root<Course> root=criteriaQuery.from(Course.class);
        Join<Course, model.entities.Currency> join=root.join("currency");
        return session.createQuery(criteriaQuery).getResultList();

        /*
        //HQL-based
        Query query=session.createQuery("FROM Course");
        return query.list();
        */

    }

    public List<Course> getCourses(Calendar fromDate) {
        Session session=getSessionFactory().getCurrentSession();
        fromDate.set(Calendar.MINUTE,00);
        fromDate.set(Calendar.HOUR,00);

        /*
        //Criteria-based
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery=criteriaBuilder.createQuery(Course.class);
        Root<Course> root=criteriaQuery.from(Course.class);
        Join<Course, model.entities.Currency> join=root.join("currency");
        return session.createQuery(criteriaQuery).getResultList();
        */
        return null;
        /*
        //HQL-based
        Query query=session.createQuery("FROM Course");
        return query.list();
        */
    }

    public List<Course> getCourses(Calendar fromDate, Calendar toDate) {
        Session session=getSessionFactory().getCurrentSession();
        fromDate.set(Calendar.MINUTE,00);
        fromDate.set(Calendar.HOUR,00);
        toDate.set(Calendar.MINUTE,00);
        toDate.set(Calendar.HOUR,00);

        /*
        //Criteria-based
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery=criteriaBuilder.createQuery(Course.class);
        Root<Course> root=criteriaQuery.from(Course.class);
        Join<Course, model.entities.Currency> join=root.join("currency");
        return session.createQuery(criteriaQuery).getResultList();
        */
        return null;
        /*
        //HQL-based
        Query query=session.createQuery("FROM Course");
        return query.list();
        */
    }
}
