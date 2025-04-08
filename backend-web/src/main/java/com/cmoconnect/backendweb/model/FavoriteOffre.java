package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

@Entity
public class FavoriteOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    private Boolean estActive;  // Indique si l'offre est marquée comme favorite

    // Getters et Setters
}
