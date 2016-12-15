package Settings;

import model.Requesters.RequestersController;
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
        SpringRequestersConfiguration.class,
        //SpringServicesConfiguration.class
        })
public class SpringConfiguration {
        @Inject
        private SpringRequestersConfiguration requestersConfiguration;

        @Bean
        public RequestersController requestersController()
        {
                return new RequestersController(requestersConfiguration.fixerioRequester());
        }
}
