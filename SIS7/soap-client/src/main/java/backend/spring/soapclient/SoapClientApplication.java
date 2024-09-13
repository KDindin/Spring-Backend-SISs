package backend.spring.soapclient;

import backend.spring.soapclient.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(SoapClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient countryClient) {
		return args -> {
			String country = "Poland";

				if (args.length > 0) {
					country = args[0];
				}
			GetCountryResponse response = countryClient.getCountry(country);
			System.out.println(response.getCountry().getCurrency());
		};
	}

}
