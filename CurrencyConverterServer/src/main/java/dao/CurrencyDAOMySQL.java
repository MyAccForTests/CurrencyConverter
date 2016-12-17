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

    public CurrencyDAOMySQL(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void add(List<Currency> list) {

    }

    public void update(List<Currency> list) {

    }

    public List<Currency> getCurrencies() {
        List<Currency> result=null;
        try(Session session=getSessionFactory().openSession())
        {
            Transaction transaction=null;
            try {
                transaction = session.beginTransaction();
                Query query = session.createQuery("FROM Currency cur WHERE cur.id =:id");
                query.setParameter("id", 1);
                result = query.list();
                transaction.commit();
            }
            catch (Exception e)
            {
                transaction.rollback();
                System.out.println("DB error happens!");
            }
        }
        catch (Exception e)
        {
            System.out.println("DB error happens!");
        }
        return result;
    }

    public List<Currency> getCurrencies(Calendar fromDate) {
        return null;
    }

    public List<Currency> getCurrencies(Calendar fromDate, Calendar toDate) {
        return null;
    }

}
