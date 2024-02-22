package com.jsmc.service.impl;

import com.jsmc.client.SoapClient;
import com.jsmc.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final SoapClient calculatorClient;


    @Override
    public String add(Integer numberA, Integer numberB) {
        return calculatorClient.addTwoNumbers(numberA, numberB);
    }

    @Override
    public String subtract(Integer numberA, Integer numberB) {
        return calculatorClient.subtractTwoNumbers(numberA, numberB);
    }


}
