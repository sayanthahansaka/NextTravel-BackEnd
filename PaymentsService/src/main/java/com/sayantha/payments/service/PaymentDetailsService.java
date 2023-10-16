package com.sayantha.payments.service;

import com.sayantha.payments.dto.PaymentDetailsDTO;

import java.util.List;

public interface PaymentDetailsService {

    PaymentDetailsDTO savePaymentDetails(PaymentDetailsDTO paymentDetailsDTO);

    PaymentDetailsDTO updatePaymentDetails(PaymentDetailsDTO paymentDetailsDTO);

    void deletePaymentDetailsById(int id);

    List<PaymentDetailsDTO> getAllPaymentDetails();

    PaymentDetailsDTO getPaymentDetailsById(int id);
}

