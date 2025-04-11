package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.PaymentsAbonnement;
import com.cmoconnect.backendweb.repository.PaymentAbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentAbonnementService {

    @Autowired
    private PaymentAbonnementRepository paymentAbonnementRepository;

    public PaymentsAbonnement createPaymentAbonnement(PaymentsAbonnement paymentAbonnement) {
        return paymentAbonnementRepository.save(paymentAbonnement);
    }

    public List<PaymentsAbonnement> getAllPaymentAbonnements() {
        return paymentAbonnementRepository.findAll();
    }

    public PaymentsAbonnement getPaymentAbonnementById(Long id) {
        return paymentAbonnementRepository.findById(id).orElse(null);
    }

    public PaymentsAbonnement updatePaymentAbonnement(Long id, PaymentsAbonnement paymentAbonnement) {
        if (paymentAbonnementRepository.existsById(id)) {
            paymentAbonnement.setId(id);
            return paymentAbonnementRepository.save(paymentAbonnement);
        }
        return null;
    }

    public void deletePaymentAbonnement(Long id) {
        paymentAbonnementRepository.deleteById(id);
    }

    public List<PaymentsAbonnement> getPaymentsByUtilisateur(Long utilisateurId) {
        return paymentAbonnementRepository.findByUtilisateurId(utilisateurId);
    }
}