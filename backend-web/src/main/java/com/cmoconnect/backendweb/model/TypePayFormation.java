package com.cmoconnect.backendweb.model;
import jakarta.persistence.*;
@Entity
public class TypePayFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;  // Type de paiement (ex. Carte bancaire, PayPal, etc.)

    // Getters et Setters
}
