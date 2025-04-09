package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.PaymentsAbonnement;
import com.cmoconnect.backendweb.repository.PaymentAbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentAbonnementService {

    @Autowired
    private PaymentAbonnementRepository paymentAbonnementRepository;

    public PaymentsAbonnement createPaymentAbonnement(PaymentsAbonnement paymentAbonnement) {
        return paymentAbonnementRepository.save(paymentAbonnement);
    }
}