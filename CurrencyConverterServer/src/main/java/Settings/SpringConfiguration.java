package settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Ilua on 15.12.2016.
 */
@Configuration
@EnableScheduling
@EnableAsync
@EnableWebMvc
@ComponentScan({"settings", "databaseDAO", "requesterDAO", "model", "controllers"})
public class SpringConfiguration {
    @Bean
    public ThreadPoolTaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(2);
        return  taskScheduler;
    }
}
