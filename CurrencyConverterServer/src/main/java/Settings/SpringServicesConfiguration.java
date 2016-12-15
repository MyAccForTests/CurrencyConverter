package Settings;

import model.Sevices.CurrencyCRUDService;
import model.Sevices.CurrencyMySQLService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
public class SpringServicesConfiguration {

    @Bean
    public CurrencyCRUDService currencyMySQLService()
    {
        return new CurrencyMySQLService();
    }
}
