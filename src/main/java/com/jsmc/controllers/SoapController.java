package com.jsmc.controllers;

import com.jsmc.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("/soap/calculator")
@AllArgsConstructor
public class SoapController {

    private final CalculatorService calculatorService;

    @GetMapping("/add")
    public ResponseEntity<String> addTwoNumbers(@RequestParam @PositiveOrZero @Digits(fraction = 0, integer = 5) Integer numberA,
                                                @RequestParam @PositiveOrZero @Digits(fraction = 0, integer = 5) Integer numberB) {
        return ResponseEntity.ok(calculatorService.add(numberA, numberB));

    }

    @GetMapping("/subtract")
    public ResponseEntity<String> subtractTwoNumbers(@RequestParam @PositiveOrZero @Digits(fraction = 0, integer = 5) Integer numberA,
                                                     @RequestParam @PositiveOrZero @Digits(fraction = 0, integer = 5) Integer numberB) {
        return ResponseEntity.ok(calculatorService.subtract(numberA, numberB));

    }


}
