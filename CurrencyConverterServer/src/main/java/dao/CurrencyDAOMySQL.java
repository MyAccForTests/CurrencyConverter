package dao;

import model.entities.Currency;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Calendar;
import java.util.List;

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
        fromDate.set(2012,11,12);
        fromDate.set(Calendar.MINUTE,00);
        fromDate.set(Calendar.HOUR,00);
        Session session=getSessionFactory().getCurrentSession();
        Query query=session.createQuery("FROM Currency cur JOIN cur.values val WHERE index(val)>= :fromDate");
        query.setParameter("fromDate",fromDate,TemporalType.DATE);
        List<Currency> result=query.list();
        //System.out.println(fromDate.getTime().toString());
        return result;
    }

    public List<Currency> getCurrencies(Calendar fromDate, Calendar toDate) {
        return null;
    }
}
