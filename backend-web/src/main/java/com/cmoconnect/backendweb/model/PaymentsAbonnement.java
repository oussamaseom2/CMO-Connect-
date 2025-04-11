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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public TypePayAbonnement getTypePayAbonnement() {
        return typePayAbonnement;
    }

    public void setTypePayAbonnement(TypePayAbonnement typePayAbonnement) {
        this.typePayAbonnement = typePayAbonnement;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public String getMMIYY() {
        return MMIYY;
    }

    public void setMMIYY(String MMIYY) {
        this.MMIYY = MMIYY;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
