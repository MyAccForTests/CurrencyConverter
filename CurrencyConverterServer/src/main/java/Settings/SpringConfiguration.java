package Settings;

import model.Services.DAOSevice.CurrencyService;
import model.Services.RequestersService.RequesterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.inject.Inject;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
@Import({
        SpringDAOConfiguration.class,
        SpringServicesConfiguration.class,
        SpringRequestersConfiguration.class
        })
public class SpringConfiguration {

}
