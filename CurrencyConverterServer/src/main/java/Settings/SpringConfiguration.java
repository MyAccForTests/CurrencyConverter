package settings;

import dao.CurrencyDAO;
import dao.CurrencyDAOMySQL;
import model.services.CurrencyDAOService;
import model.services.CurrencyRequesterService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import requesters.CurrencyFixerioRequester;


/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
@ComponentScan({"settings"})
public class SpringConfiguration {

        @Bean(name = "MySQL")
        @Autowired
        public CurrencyDAO currencyDAOMySQL(SessionFactory sessionFactory)
        {
            return new CurrencyDAOMySQL(sessionFactory);
        }

        @Bean(name = "s")
        @Autowired
        //@Transactional
        @Qualifier("MySQL")
        public CurrencyDAOService currencyDAOService(CurrencyDAO currencyDAO)
        {
            return new CurrencyDAOService(currencyDAO);
        }
    /*
       @Bean
       @Autowired
       public CurrencyDAOService currencyDAOService(SessionFactory sessionFactory)
       {
           return new CurrencyDAOService(new CurrencyDAOMySQL(sessionFactory));
       }
   */
    @Bean
    public CurrencyRequesterService currencyRequesterService()
    {
        return new CurrencyRequesterService(new CurrencyFixerioRequester());
    }
}
