package settings.RequesterSettings;

import model.services.CurrencyRequesterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import requesters.CurrencyFixerioRequester;
import requesters.CurrencyOpenexchangerateRequester;
import requesters.CurrencyRequester;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
@Profile("FixerIO")
public class SpringFixerioConfiguration {

    @Bean (name = "FixerIOService")
    public CurrencyRequesterService currencyRequesterService()
    {
        CurrencyRequesterService service=new CurrencyRequesterService();
        service.setService(currencyRequester());
        return service;
    }

    @Bean
    public CurrencyRequester currencyRequester()
    {
        return new CurrencyFixerioRequester();
    }
}
