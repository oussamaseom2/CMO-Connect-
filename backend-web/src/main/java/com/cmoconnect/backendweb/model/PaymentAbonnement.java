package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class PaymentAbonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;
    private String modePaiement;
    private String statut;
    private String reference;
    private String numeroCarte;
    private String MMIYY;
    private String CVC;
    private String country;
    private String address1;
    private String address2;
    private String postalCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaiement;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExpiration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abonnement_id", nullable = false)
    private Abonnement abonnement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_pay_abonnement_id", nullable = false)
    private TypePayAbonnement typePayAbonnement;
}
