package com.sayantha.payments.controller;


import com.sayantha.payments.dto.PaymentDetailsDTO;
import com.sayantha.payments.service.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-details")
public class PaymentDetailsController {

    @Autowired
    private PaymentDetailsService paymentDetailsService;

    @GetMapping
    public ResponseEntity<List<PaymentDetailsDTO>> getAllPaymentDetails() {
        return ResponseEntity.ok(paymentDetailsService.getAllPaymentDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDetailsDTO> getPaymentDetailsById(@PathVariable int id) {
        return ResponseEntity.ok(paymentDetailsService.getPaymentDetailsById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentDetailsDTO> createPaymentDetails(@RequestBody PaymentDetailsDTO paymentDetailsDTO) {
        return ResponseEntity.ok(paymentDetailsService.savePaymentDetails(paymentDetailsDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDetailsDTO> updatePaymentDetails(@PathVariable int id, @RequestBody PaymentDetailsDTO paymentDetailsDTO) {
        // Check the ID from the path against the ID in the DTO to ensure they match or handle accordingly
        if (id != paymentDetailsDTO.getPaymentId()) {
            return ResponseEntity.badRequest().build(); // or another appropriate error response
        }
        return ResponseEntity.ok(paymentDetailsService.updatePaymentDetails(paymentDetailsDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentDetails(@PathVariable int id) {
        paymentDetailsService.deletePaymentDetailsById(id);
        return ResponseEntity.noContent().build();
    }
}
