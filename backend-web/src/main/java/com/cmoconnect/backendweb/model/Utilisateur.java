package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;  // Nom de l'utilisateur
    private String prenom;  // Prénom de l'utilisateur
    private String password;  // Mot de passe de l'utilisateur
    private Date dateInscription;  // Date d'inscription
    private Date derniereDateConn;  // Dernière date de connexion
    private String tel;  // Numéro de téléphone de l'utilisateur
    private String photo;  // Photo de l'utilisateur
    private String cv;  // CV de l'utilisateur

    private String autoProvider;  // Fournisseur automatique (si applicable)

    @ElementCollection
    private List<String> portFolios;  // Liste de portfolios de type String

    @Enumerated(EnumType.STRING)
    private UtilisateurRole role;  // Rôle de l'utilisateur (Admin, Candidat, etc.)

    public void setId(Long id) {
    }

    // Getters et Setters
}
