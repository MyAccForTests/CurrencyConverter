package settings;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
@ComponentScan({"settings", "databaseDAO", "requestersDAO", "model"})
public class SpringConfiguration {

}
