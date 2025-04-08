package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class NoteFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    private String note;  // Note attribuée à la formation
    private Date dateEvaluation;  // Date de l'évaluation

    // Getters et Setters
}
