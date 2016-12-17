package Settings;

import Requesters.CurrencyRequester;
import Requesters.FixerioRequester;
import Requesters.OpenexchangerateRequester;
import model.Services.DAOSevice.CurrencyService;
import model.Services.RequestersService.RequesterService;
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
    public RequesterService requestersController()
    {
        return new RequesterService(springRequestersConfiguration.getCurrencyRequester());
    }

    @Bean
    public CurrencyService currencyService()
    {
        return new CurrencyService(springDAOConfiguration.getCurrencyDAO());
    }

}
