package settings;

import dao.CurrencyDAO;
import dao.CurrencyDAOMySQL;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
public class SpringDAOConfiguration
{
    /*
    @Bean
    @Autowired

    public CurrencyDAO currencyDAO(SessionFactory sessionFactory) {
        return new CurrencyDAOMySQL(sessionFactory);
    }
    */
}