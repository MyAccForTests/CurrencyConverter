package dao;

import model.entities.Currency;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 14.12.2016.
 */
@Repository("MySQL")
public class CurrencyDAOMySQL extends CurrencyDAOAbstract {
    public CurrencyDAOMySQL() {
    }

    public void add(List<Currency> list) {

    }

    public void update(List<Currency> list) {

    }

    public List<Currency> getCurrencies() {
        Session session=getSessionFactory().getCurrentSession();
        Query query = session.createQuery("SELECT cur FROM Currency cur JOIN cur.values");
        List<Currency> result=query.list();
        return result;
    }

    public List<Currency> getCurrencies(Calendar fromDate) {
        return null;
    }

    public List<Currency> getCurrencies(Calendar fromDate, Calendar toDate) {
        return null;
    }

}
