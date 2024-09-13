package backend.spring.soap_client_task2;

import backend.spring.soap_client_task2.wsdl.NumberToWords;
import backend.spring.soap_client_task2.wsdl.NumberToWordsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;

public class NumberConverterClient2 extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(NumberConverterClient.class);

    public NumberToWordsResponse convertNumberToWord(BigInteger number){
        NumberToWords request = new NumberToWords();
        request.setUbiNum(number);

        log.info(number + " is being converted to words");

        return (NumberToWordsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL", request);
    }
}
