package com.cmoconnect.backendweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TypeReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;  // Icône associée au type de réaction
    private String titre;  // Titre de la réaction

    // Getters et Setters
}
