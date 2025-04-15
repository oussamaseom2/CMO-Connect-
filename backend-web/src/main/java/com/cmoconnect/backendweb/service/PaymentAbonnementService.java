package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.PaymentAbonnement;
import com.cmoconnect.backendweb.repository.PaymentAbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentAbonnementService {

    @Autowired
    private PaymentAbonnementRepository paymentAbonnementRepository;

    public PaymentAbonnement createPaymentAbonnement(PaymentAbonnement paymentAbonnement) {
        return paymentAbonnementRepository.save(paymentAbonnement);
    }

    public List<PaymentAbonnement> getAllPaymentAbonnements() {
        return paymentAbonnementRepository.findAll();
    }

    public Optional<PaymentAbonnement> getPaymentAbonnementById(Long id) {
        return paymentAbonnementRepository.findById(id);
    }

    public PaymentAbonnement updatePaymentAbonnement(Long id, PaymentAbonnement paymentAbonnement) {
        if (paymentAbonnementRepository.existsById(id)) {
            paymentAbonnement.setId(id);
            return paymentAbonnementRepository.save(paymentAbonnement);
        }
        return null;
    }

    public void deletePaymentAbonnement(Long id) {
        paymentAbonnementRepository.deleteById(id);
    }

    public List<PaymentAbonnement> getPaymentsByUtilisateur(Long utilisateurId) {
        return paymentAbonnementRepository.findByUtilisateurId(utilisateurId);
    }
}