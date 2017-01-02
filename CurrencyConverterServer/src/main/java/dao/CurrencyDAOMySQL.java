package dao;

import model.entities.Currency;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.MapAttribute;
import java.util.*;

/**
 * Created by Ilua on 14.12.2016.
 */
@Repository("MySQL")
public class CurrencyDAOMySQL extends CurrencyDAOAbstract {
    public CurrencyDAOMySQL() {
    }

    public void update(List<Currency> list) {
        Session session=getSessionFactory().getCurrentSession();
        List<Currency> currencies=getCurrencies(Calendar.getInstance());
        for(Currency temp:list)
        {
            for(Currency temp2:currencies)
            {
                session.merge(temp);
                session.saveOrUpdate(temp);
                session.flush();
            }
        }
    }

    public void updateAll(List<Currency> list) {
        /*
        Session session=getSessionFactory().getCurrentSession();
        for(Currency team:list)
        {
            session.save(team);
            session.flush();
        }
        */
    }

    public List<Currency> getCurrencies() {
        Session session=getSessionFactory().getCurrentSession();
        //HQL-based
         /*
        Query query=session.createQuery("FROM Currency");
        return query.list();
        */
        //Criteria-based
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Currency> criteriaQuery=criteriaBuilder.createQuery(Currency.class);
        criteriaQuery.from(Currency.class);
        return session.createQuery(criteriaQuery).getResultList();
    }

    public List<Currency> getCurrencies(Calendar fromDate) {
        fromDate.set(Calendar.MINUTE,00);
        fromDate.set(Calendar.HOUR,00);
        Session session=getSessionFactory().getCurrentSession();
        //HQL-based

        Query query=session.createQuery("SELECT DISTINCT cur FROM Currency cur JOIN fetch cur.values val WHERE index(val)>= :fromDate");
        query.setParameter("fromDate",fromDate,TemporalType.DATE);
        return query.list();

        //Criteria-based
        /*
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Currency> criteriaQuery=criteriaBuilder.createQuery(Currency.class);
        criteriaQuery.distinct(true);
        Root<Currency> root=criteriaQuery.from(Currency.class);
        //root.fetch("values");
        MapJoin<Currency,Calendar,Double> map=root.joinMap("values");
        criteriaQuery.where(criteriaBuilder.or(criteriaBuilder.greaterThan(map.key(),fromDate),criteriaBuilder.equal(map.key(),fromDate)));
        return session.createQuery(criteriaQuery).getResultList();
        */
    }

    public List<Currency> getCurrencies(Calendar fromDate, Calendar toDate) {
        fromDate.set(Calendar.MINUTE,00);
        fromDate.set(Calendar.HOUR,00);
        toDate.set(Calendar.MINUTE,00);
        toDate.set(Calendar.HOUR,00);
        Session session=getSessionFactory().getCurrentSession();
        Query query=session.createQuery("SELECT DISTINCT cur FROM Currency cur JOIN fetch cur.values val WHERE index(val) BETWEEN :fromDate AND :toDate" );
        query.setParameter("fromDate",fromDate,TemporalType.DATE);
        query.setParameter("toDate",toDate,TemporalType.DATE);
        return query.list();
    }
}
