package backend.spring.task2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Task2Application {

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(Task2Application.class);
		// uncomment below line if you are not using spring.factories
		//springApplication.addListeners(new SpringBuiltInEventsListener());
		springApplication.run(args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationEventPublisher publisher) {
		return args -> {
			// Publish events
			Publisher publisherComponent = new Publisher(publisher);
			publisherComponent.publishEvent();
		};
	}

}
