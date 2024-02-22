package com.jsmc.config;

import com.jsmc.client.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapCalculatorClient {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.jsmc.soap.wsdl.gen");
        return marshaller;
    }

    @Bean
    @Primary
    public SoapClient getSoapClient(Jaxb2Marshaller marshaller) {
        SoapClient soapClient = new SoapClient();
        soapClient.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);
        return soapClient;
    }
}
