package model.Sevices;

import dao.Currency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 14.12.2016.
 */
public class CurrencyMySQLService extends AbstractService {

    public CurrencyMySQLService(SessionFactory sessionFactory) {
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
            Transaction transaction = session.beginTransaction();
            Query query=session.createQuery("SELECT FROM currencies where id =:id");
            query.setParameter("id",1);
            result=query.list();
            transaction.commit();
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
