package backend.spring.soap_client_task2;

import backend.spring.soap_client_task2.wsdl.NumberToDollars;
import backend.spring.soap_client_task2.wsdl.NumberToDollarsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigDecimal;

public class NumberConverterClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(NumberConverterClient.class);

    public NumberToDollarsResponse convertNumberToDollar(BigDecimal number){
        NumberToDollars request = new NumberToDollars();
        request.setDNum(number);

        log.info(number + " is being converted to dollars");

        return (NumberToDollarsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL", request);
    }

}
