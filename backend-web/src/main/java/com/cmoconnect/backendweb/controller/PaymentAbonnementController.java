package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.PaymentsAbonnement;
import com.cmoconnect.backendweb.service.PaymentAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-abonnements")
public class PaymentAbonnementController {

    @Autowired
    private PaymentAbonnementService paymentAbonnementService;

    @PostMapping("/")
    public ResponseEntity<PaymentsAbonnement> createPaymentAbonnement(@RequestBody PaymentsAbonnement paymentAbonnement) {
        return ResponseEntity.ok(paymentAbonnementService.createPaymentAbonnement(paymentAbonnement));
    }

    @GetMapping("/")
    public ResponseEntity<List<PaymentsAbonnement>> getAllPaymentAbonnements() {
        return ResponseEntity.ok(paymentAbonnementService.getAllPaymentAbonnements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentsAbonnement> getPaymentAbonnementById(@PathVariable Long id) {
        PaymentsAbonnement paymentAbonnement = paymentAbonnementService.getPaymentAbonnementById(id);
        if (paymentAbonnement != null) {
            return ResponseEntity.ok(paymentAbonnement);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentsAbonnement> updatePaymentAbonnement(@PathVariable Long id, @RequestBody PaymentsAbonnement paymentAbonnement) {
        PaymentsAbonnement updatedPaymentAbonnement = paymentAbonnementService.updatePaymentAbonnement(id, paymentAbonnement);
        if (updatedPaymentAbonnement != null) {
            return ResponseEntity.ok(updatedPaymentAbonnement);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentAbonnement(@PathVariable Long id) {
        paymentAbonnementService.deletePaymentAbonnement(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public ResponseEntity<List<PaymentsAbonnement>> getPaymentsByUtilisateur(@PathVariable Long utilisateurId) {
        return ResponseEntity.ok(paymentAbonnementService.getPaymentsByUtilisateur(utilisateurId));
    }
} 