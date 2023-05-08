package ch.finecloud.demo.config;

import ch.finecloud.demo.json.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Greeting defaultGreeting() {
        return new Greeting ("Hello, World!");
    }

    @Bean
    public Greeting whatUpGreeting() {
        return new Greeting ("What up, World!");
    }
}
