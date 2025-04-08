package com.cmoconnect.backendweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TypePayAbonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;  // Type de paiement (par exemple, "Carte bancaire", "PayPal")

    // Getters et Setters
}
