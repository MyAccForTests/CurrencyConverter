package dao;

import model.entities.Currency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 14.12.2016.
 */
public class CurrencyDAOMySQL extends CurrencyDAOAbstract {
    public CurrencyDAOMySQL() {
    }

    public CurrencyDAOMySQL(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void add(List<Currency> list) {

    }

    public void update(List<Currency> list) {

    }

    public List<Currency> getCurrencies() {
        Session session=getSessionFactory().getCurrentSession();
        Query query = session.createQuery("FROM Currency cur WHERE cur.id =:id");
        query.setParameter("id", 1);
        List<Currency> result= query.list();
        return result;
    }

    public List<Currency> getCurrencies(Calendar fromDate) {
        return null;
    }

    public List<Currency> getCurrencies(Calendar fromDate, Calendar toDate) {
        return null;
    }

}
