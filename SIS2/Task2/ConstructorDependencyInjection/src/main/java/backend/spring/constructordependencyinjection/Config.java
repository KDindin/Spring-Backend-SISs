package backend.spring.constructordependencyinjection;


import backend.spring.constructordependencyinjection.domain.Engine;
import backend.spring.constructordependencyinjection.domain.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("backend.spring.constructordependencyinjection")
public class Config {

    @Bean
    public Engine engine() {
        return new Engine("v8", 5);
    }

    @Bean
    public Transmission transmission() {
        return new Transmission("sliding");
    }
}