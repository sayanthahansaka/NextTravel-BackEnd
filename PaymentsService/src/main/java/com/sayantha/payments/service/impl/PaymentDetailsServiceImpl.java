package com.sayantha.payments.service.impl;

import com.sayantha.payments.dto.PaymentDetailsDTO;
import com.sayantha.payments.entity.PaymentsDetails;
import com.sayantha.payments.repo.PaymentDetailsRepo;
import com.sayantha.payments.service.PaymentDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

    @Autowired
    private PaymentDetailsRepo paymentDetailsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PaymentDetailsDTO savePaymentDetails(PaymentDetailsDTO paymentDetailsDTO) {
        PaymentsDetails paymentsDetails = modelMapper.map(paymentDetailsDTO, PaymentsDetails.class);
        PaymentsDetails savedPaymentsDetails = paymentDetailsRepo.save(paymentsDetails);
        return modelMapper.map(savedPaymentsDetails, PaymentDetailsDTO.class);
    }

    @Override
    public PaymentDetailsDTO updatePaymentDetails(PaymentDetailsDTO paymentDetailsDTO) {
        if (!paymentDetailsRepo.existsById(paymentDetailsDTO.getPaymentId())) {
            throw new RuntimeException("Payment ID not found: " + paymentDetailsDTO.getPaymentId());
        }

        PaymentsDetails paymentsDetails = modelMapper.map(paymentDetailsDTO, PaymentsDetails.class);
        PaymentsDetails updatedPaymentsDetails = paymentDetailsRepo.save(paymentsDetails);
        return modelMapper.map(updatedPaymentsDetails, PaymentDetailsDTO.class);
    }

    @Override
    public void deletePaymentDetailsById(int id) {
        paymentDetailsRepo.deleteById(id);
    }

    @Override
    public List<PaymentDetailsDTO> getAllPaymentDetails() {
        List<PaymentsDetails> paymentsDetailsList = paymentDetailsRepo.findAll();
        return paymentsDetailsList.stream()
                .map(paymentsDetails -> modelMapper.map(paymentsDetails, PaymentDetailsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDetailsDTO getPaymentDetailsById(int id) {
        Optional<PaymentsDetails> optionalPaymentsDetails = paymentDetailsRepo.findById(id);
        if (optionalPaymentsDetails.isPresent()) {
            return modelMapper.map(optionalPaymentsDetails.get(), PaymentDetailsDTO.class);
        }
        throw new RuntimeException("Payment ID not found: " + id);
    }
}
