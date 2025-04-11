package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

@Entity
public class CompetenceRequired {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    private String competence;  // Compétence requise pour l'offre

    // Getters et Setters
}

