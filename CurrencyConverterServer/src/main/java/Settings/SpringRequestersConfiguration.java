package Settings;

import model.Requesters.CurrencyRequester;
import model.Requesters.FixerioRequester;
import model.Requesters.OpenexchangerateRequester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
public class SpringRequestersConfiguration {

    @Bean
    public CurrencyRequester fixerioRequester()
    {
        return new FixerioRequester();
    }

    @Bean
    public OpenexchangerateRequester openexchangerateRequester()
    {
        return new OpenexchangerateRequester();
    }
}
