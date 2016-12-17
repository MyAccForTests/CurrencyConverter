package settings;

import requesters.CurrencyRequester;
import requesters.FixerioRequester;
import requesters.OpenexchangerateRequester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
public class SpringRequestersConfiguration {

    private CurrencyRequester currencyRequester=fixerioRequester();

    public CurrencyRequester getCurrencyRequester() {
        return currencyRequester;
    }

    @Bean
    public CurrencyRequester fixerioRequester()
    {
        return new FixerioRequester();
    }

    @Bean
    public CurrencyRequester openexchangerateRequester()
    {
        return new OpenexchangerateRequester();
    }
}
