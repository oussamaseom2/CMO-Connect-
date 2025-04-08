package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

@Entity
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;  // Utilisateur ayant l'abonnement

    @ManyToOne
    @JoinColumn(name = "typePayAbonnement_id")
    private TypePayAbonnement typePayAbonnement;  // Type d'abonnement (payant ou gratuit)

    private Float prixTotal;  // Prix total de l'abonnement
    private Date dateDebut;  // Date de début de l'abonnement
    private Date dateFin;  // Date de fin de l'abonnement
    private Boolean renouvellementAutomatique;  // Indicateur du renouvellement automatique

    // Getters et Setters
}
