package dao;

import model.entities.Currency;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import javax.persistence.criteria.*;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Ilua on 14.12.2016.
 */
@Repository("MySQL")
public class CurrencyDAOMySQL extends CurrencyDAOAbstract {
    public CurrencyDAOMySQL() {
    }

    public void update(List<Currency> list) {
        /*
        Session session=getSessionFactory().getCurrentSession();
        for(Currency team:list)
        {
            session.save(team);
            session.flush();
        }
        */
    }

    public void updateAll(List<Currency> list) {

    }

    public List<Currency> getCurrencies() {
        Session session=getSessionFactory().getCurrentSession();
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Currency> criteriaQuery=criteriaBuilder.createQuery(Currency.class);
        criteriaQuery.from(Currency.class);
        return session.createQuery(criteriaQuery).getResultList();
    }

    public List<Currency> getCurrencies(Calendar fromDate) {
        fromDate.set(2012,11,14);
        fromDate.set(Calendar.MINUTE,00);
        fromDate.set(Calendar.HOUR,00);
        Session session=getSessionFactory().getCurrentSession();

        /*  //HQL-based
        Query query=session.createQuery("SELECT DISTINCT cur FROM Currency cur JOIN fetch cur.values val WHERE index(val)>= :fromDate");
        query.setParameter("fromDate",fromDate,TemporalType.DATE);
        return query.list();
        */
            //Criteria-based
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Currency> criteriaQuery=criteriaBuilder.createQuery(Currency.class);
        Root<Currency> root=criteriaQuery.from(Currency.class);
        root.fetch("values");
        MapJoin<Currency,Calendar,Double> map=root.joinMap("values");
        Join j=root.join("values");
        criteriaQuery.select(root);
        criteriaQuery.distinct(true);
        criteriaQuery.where(criteriaBuilder.or(criteriaBuilder.greaterThan(map.key(),fromDate),criteriaBuilder.equal(map.key(),fromDate)));
        return session.createQuery(criteriaQuery).getResultList();
    }

    public List<Currency> getCurrencies(Calendar fromDate, Calendar toDate) {
        return null;
    }
}
