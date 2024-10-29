package com.example.PaymentService.controllers;

import com.example.PaymentService.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;
    @PostMapping("/pay-bill")
    public Boolean paymentDone(@RequestParam("bookId") Long bookId, @RequestParam("quantity") Long quantity, @RequestParam("UserId") Long userId) {

        Boolean validBalance = paymentService.validBalance(bookId, quantity, userId);

        if (validBalance) {
            paymentService.updateBalance(bookId, quantity, userId);
        }

        return validBalance;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello From Payment Service!",HttpStatus.ACCEPTED);
    }
}
