package settings;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
