package com.cmoconnect.backendweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;  // Titre de la formation
    private String description;  // Description de la formation
    private Integer duree;  // Durée de la formation en heures
    private Integer nbreChapitre;  // Nombre de chapitres
    private String type;  // Type de formation (e.g., en ligne, en présentiel)
    private Double prix;  // Prix de la formation
    private Boolean eSatisfait;  // Indicateur de satisfaction de la formation
    private Integer nbreInscription;  // Nombre d'inscriptions à la formation
    private String quiz;  // Quiz associé à la formation

    // Getters et Setters
}

