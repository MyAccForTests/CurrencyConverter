package settings;

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
public class SpringRequestersConfiguration {

    @Profile("OpenExchangeRate")
    @Bean (name = "OpenExchangeRateService")
    public CurrencyRequesterService currencyOpenexchangerateService()
    {
        CurrencyRequesterService service=new CurrencyRequesterService();
        service.setService(currencyOpenexchangerateRequester());
        return service;
    }

    @Bean
    public CurrencyRequester currencyOpenexchangerateRequester()
    {
        return new CurrencyOpenexchangerateRequester();
    }

    @Profile("FixerIO")
    @Bean (name = "FixerIOService")
    public CurrencyRequesterService currencyFixerioService()
    {
        CurrencyRequesterService service=new CurrencyRequesterService();
        service.setService(currencyFixerioRequester());
        return service;
    }

    @Bean
    public CurrencyRequester currencyFixerioRequester()
    {
        return new CurrencyFixerioRequester();
    }
}
