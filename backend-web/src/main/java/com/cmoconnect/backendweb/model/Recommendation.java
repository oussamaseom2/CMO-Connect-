package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateurRecevant_id")
    private Utilisateur utilisateurRecevant;

    @ManyToMany(mappedBy = "utilisateursRecommandes")
    private List<Utilisateur> utilisateursRecommandes;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Utilisateur admin;

    // Getters et Setters
}
