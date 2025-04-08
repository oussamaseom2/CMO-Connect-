package com.cmoconnect.backendweb.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PaymentFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;  // Utilisateur qui a effectué le paiement

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;  // Formation payée

    private Double montant;  // Montant payé pour la formation
    private Date datePay;  // Date du paiement
    private String numeroDeSerie;  // Numéro de série de la carte utilisée pour le paiement
    private String MMYY;  // Mois et année d'expiration de la carte
    private Integer CVC;  // Code CVC de la carte
    private String cardholderName;  // Nom du titulaire de la carte
    private String country;  // Pays de l'utilisateur
    private String address1;  // Adresse de l'utilisateur
    private String address2;  // Adresse complémentaire
    private String postalCode;  // Code postal
    private String city;  // Ville

    // Getters et Setters
}
