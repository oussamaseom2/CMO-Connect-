package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PaymentsAbonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;  // Utilisateur ayant effectué le paiement

    @ManyToOne
    @JoinColumn(name = "typePayAbonnement_id")
    private TypePayAbonnement typePayAbonnement;  // Type d'abonnement payé

    private Date datePay;  // Date du paiement
    private String numeroCarte;  // Numéro de carte utilisée pour le paiement
    private String MMIYY;  // Date d'expiration (mois/année)
    private String CVC;  // Code CVC de la carte
    private String country;  // Pays de l'utilisateur
    private String address1;  // Adresse 1
    private String address2;  // Adresse 2
    private String postalCode;  // Code postal
    private Date dateExpiration;  // Date d'expiration du paiement

    // Getters et Setters
}
