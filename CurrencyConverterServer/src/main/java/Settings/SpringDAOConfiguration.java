package Settings;

import dao.Currency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
public class SpringDAOConfiguration {

    @Bean
    public Currency currency()
    {
        return new Currency();
    }
}
