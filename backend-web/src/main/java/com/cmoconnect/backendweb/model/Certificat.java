package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Certificat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    private String nom;  // Nom du certificat
    private String description;  // Description du certificat
    private Date dateObtention;  // Date d'obtention du certificat
    private String logo;  // Logo du certificat
    private Boolean estValide;  // Indique si le certificat est valide
    private String linkCertificat;  // Lien vers le certificat
    private String qrCode;  // QR Code du certificat

    // Getters et Setters
}
