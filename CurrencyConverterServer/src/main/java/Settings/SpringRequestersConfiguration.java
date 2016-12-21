package settings;

import requesters.CurrencyRequester;
import requesters.CurrencyFixerioRequester;
import requesters.CurrencyOpenexchangerateRequester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
public class SpringRequestersConfiguration {
/*
    private CurrencyRequester currencyRequester=fixerioRequester();

    public CurrencyRequester getCurrencyRequester() {
        return currencyRequester;
    }

    @Bean
    public CurrencyRequester fixerioRequester()
    {
        return new CurrencyFixerioRequester();
    }

    @Bean
    public CurrencyRequester openexchangerateRequester()
    {
        return new CurrencyOpenexchangerateRequester();
    }
    */
}
