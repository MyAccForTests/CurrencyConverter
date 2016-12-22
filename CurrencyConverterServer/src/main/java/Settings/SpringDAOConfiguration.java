package settings;

import dao.CurrencyDAO;
import dao.CurrencyDAOMySQL;
import model.services.CurrencyDBService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
public class SpringDAOConfiguration
{
    @Profile("MySQL")
    @Bean
    @Autowired
    public CurrencyDBService currencyDBService(CurrencyDAO currencyDAO)
    {
        return new CurrencyDBService(currencyDAO);
    }

    @Bean
    @Autowired
    public CurrencyDAO currencyDAOMySQL(SessionFactory sessionFactory)
    {
        return new CurrencyDAOMySQL(sessionFactory);
    }
}