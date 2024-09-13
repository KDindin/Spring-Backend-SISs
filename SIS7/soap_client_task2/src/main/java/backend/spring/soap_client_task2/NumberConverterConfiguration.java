package backend.spring.soap_client_task2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class NumberConverterConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("backend.spring.soap_client_task2.wsdl");
        return marshaller;
    }

    @Bean
    public NumberConverterClient numberConverterClient(Jaxb2Marshaller marshaller) {
        NumberConverterClient client = new NumberConverterClient();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public NumberConverterClient2 numberConverterClient2(Jaxb2Marshaller marshaller) {
        NumberConverterClient2 client2 = new NumberConverterClient2();
        client2.setDefaultUri("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL");
        client2.setMarshaller(marshaller);
        client2.setUnmarshaller(marshaller);
        return client2;
    }
}
