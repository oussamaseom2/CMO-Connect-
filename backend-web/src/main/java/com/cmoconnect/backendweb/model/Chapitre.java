package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

@Entity
public class Chapitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;  // Formation associée à ce chapitre

    private String titre;  // Titre du chapitre
    private String video;  // Vidéo du chapitre
    private String pdf;  // PDF du chapitre

    // Getters et Setters
}
