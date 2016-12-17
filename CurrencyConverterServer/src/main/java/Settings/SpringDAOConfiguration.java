package settings;

import dao.CurrencyDAO;
import dao.CurrencyDAOMySQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
public class SpringDAOConfiguration {

    private CurrencyDAO currencyDAO=currencyMySQLService();

    public CurrencyDAO getCurrencyDAO() {
        return currencyDAO;
    }

    @Bean
    public CurrencyDAO currencyMySQLService()
    {
        return new CurrencyDAOMySQL();
    }
}
