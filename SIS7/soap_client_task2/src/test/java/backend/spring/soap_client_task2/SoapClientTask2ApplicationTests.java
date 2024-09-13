package backend.spring.soap_client_task2;

import backend.spring.soap_client_task2.wsdl.NumberToDollarsResponse;
import backend.spring.soap_client_task2.wsdl.NumberToWordsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.BigInteger;

@SpringBootTest
class SoapClientTask2ApplicationTests {

    @Autowired
    NumberConverterClient countryClient;

    @Autowired
    NumberConverterClient2 countryClient2;

    @Test
    void contextLoads() {
    }

    @Test
    void test100ToDollar(){
        //Assign
        BigDecimal number = BigDecimal.valueOf(100);
        //Act
        NumberToDollarsResponse response = countryClient.convertNumberToDollar(number);
        //Assert
        Assert.hasText(response.getNumberToDollarsResult(),"NUMBER TO WORDS");
    }

    @Test
    void test100ToWord(){
        //Assign
        BigInteger number2 = BigInteger.valueOf(100);
        //Act
        NumberToWordsResponse response = countryClient2.convertNumberToWord(number2);
        //Assert
        Assert.hasText(response.getNumberToWordsResult(),"NUMBER TO WORDS");
    }

}
