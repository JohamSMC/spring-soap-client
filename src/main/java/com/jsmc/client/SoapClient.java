package com.jsmc.client;


import com.jsmc.soap.wsdl.gen.Add;
import com.jsmc.soap.wsdl.gen.AddResponse;
import com.jsmc.soap.wsdl.gen.Subtract;
import com.jsmc.soap.wsdl.gen.SubtractResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
@AllArgsConstructor
public class SoapClient extends WebServiceGatewaySupport {

    public String addTwoNumbers(Integer numberOne, Integer numberTwo) {
        Add request = new Add();
        request.setIntA(numberOne);
        request.setIntB(numberTwo);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Add");
        AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, soapActionCallback);

        return String.valueOf(response.getAddResult());

    }

    public String subtractTwoNumbers(Integer numberOne, Integer numberTwo) {
        Subtract request = new Subtract();
        request.setIntA(numberOne);
        request.setIntB(numberTwo);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Subtract");
        SubtractResponse response = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, soapActionCallback);

        return String.valueOf(response.getSubtractResult());

    }
}
