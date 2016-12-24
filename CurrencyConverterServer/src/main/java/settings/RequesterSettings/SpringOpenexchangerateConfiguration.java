package settings.RequesterSettings;

import model.services.CurrencyRequesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import requesters.CurrencyOpenexchangerateRequester;
import requesters.CurrencyRequester;
import requesters.CurrencyFixerioRequester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
@Profile("OpenExchangeRate")
public class SpringOpenexchangerateConfiguration {

    @Bean (name = "OpenExchangeRateService")
    public CurrencyRequesterService currencyRequesterService()
    {
        CurrencyRequesterService service=new CurrencyRequesterService();
        service.setService(currencyRequester());
        return service;
    }
    @Bean
    public CurrencyRequester currencyRequester()
    {
        return new CurrencyOpenexchangerateRequester();
    }
}
