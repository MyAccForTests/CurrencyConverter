package settings;

import model.services.CurrencyDAOService;
import model.services.CurrencyRequesterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
public class SpringServicesConfiguration {
    @Inject
    private SpringRequestersConfiguration springRequestersConfiguration;
    private SpringDAOConfiguration springDAOConfiguration;

    @Bean
    public CurrencyRequesterService requestersController()
    {
        return new CurrencyRequesterService(springRequestersConfiguration.getCurrencyRequester());
    }

    @Bean
    public CurrencyDAOService currencyService()
    {
        return new CurrencyDAOService(springDAOConfiguration.getCurrencyDAO());
    }

}
