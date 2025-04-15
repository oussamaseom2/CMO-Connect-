package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.PaymentAbonnement;
import com.cmoconnect.backendweb.service.PaymentAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment-abonnements")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class PaymentAbonnementController {
    @Autowired
    private PaymentAbonnementService paymentAbonnementService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentAbonnement> createPaymentAbonnement(@RequestBody PaymentAbonnement paymentAbonnement) {
        PaymentAbonnement created = paymentAbonnementService.createPaymentAbonnement(paymentAbonnement);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PaymentAbonnement>> getAllPaymentAbonnements() {
        List<PaymentAbonnement> paymentAbonnements = paymentAbonnementService.getAllPaymentAbonnements();
        return new ResponseEntity<>(paymentAbonnements, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentAbonnement> getPaymentAbonnementById(@PathVariable Long id) {
        Optional<PaymentAbonnement> paymentAbonnement = paymentAbonnementService.getPaymentAbonnementById(id);
        return paymentAbonnement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentAbonnement> updatePaymentAbonnement(@PathVariable Long id, @RequestBody PaymentAbonnement paymentAbonnement) {
        PaymentAbonnement updated = paymentAbonnementService.updatePaymentAbonnement(id, paymentAbonnement);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentAbonnement(@PathVariable Long id) {
        Optional<PaymentAbonnement> paymentAbonnement = paymentAbonnementService.getPaymentAbonnementById(id);
        if (paymentAbonnement.isPresent()) {
            paymentAbonnementService.deletePaymentAbonnement(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public ResponseEntity<List<PaymentAbonnement>> getPaymentsByUtilisateur(@PathVariable Long utilisateurId) {
        return ResponseEntity.ok(paymentAbonnementService.getPaymentsByUtilisateur(utilisateurId));
    }
} 