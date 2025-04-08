package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

@Entity
public class OffreCompetenceRequired {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCompetenceRequired")
    private CompetenceRequired competenceRequired;

    @ManyToOne
    @JoinColumn(name = "idOffre")
    private TypeOffre offre;

    // Getters et Setters
}

