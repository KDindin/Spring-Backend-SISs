package backend.spring.soap_client_task2;

import backend.spring.soap_client_task2.wsdl.NumberToDollarsResponse;
import backend.spring.soap_client_task2.wsdl.NumberToWordsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.math.BigInteger;

@SpringBootApplication
public class SoapClientTask2Application {

    public static void main(String[] args) {
        SpringApplication.run(SoapClientTask2Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(NumberConverterClient countryClient) {
        return args -> {
            BigDecimal number = BigDecimal.valueOf(1000);

            if (args.length > 0) {
                number = BigDecimal.valueOf(Long.parseLong(args[0]));
            }

            NumberToDollarsResponse response = countryClient.convertNumberToDollar(number);
            System.out.println(response.getNumberToDollarsResult());
        };
    }

//    @Bean
//    CommandLineRunner lookup(NumberConverterClient2 countryClient) {
//        return args -> {
//            BigInteger number = BigInteger.valueOf(1000);
//
//            if (args.length > 0) {
//                number = BigInteger.valueOf(Long.parseLong(args[0]));
//            }
//
//            NumberToWordsResponse response = countryClient.convertNumberToWord(number);
//            System.out.println(response.getNumberToWordsResult());
//        };
//    }
}
