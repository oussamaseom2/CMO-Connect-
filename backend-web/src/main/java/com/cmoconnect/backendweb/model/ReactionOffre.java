package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ReactionOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    @ManyToOne
    @JoinColumn(name = "typeReaction_id")
    private TypeReaction typeReaction;

    private Date dateReaction;  // Date de la réaction
    private Date dateModification;  // Date de modification de la réaction
    private Boolean estActive;  // Indique si la réaction est active

    // Getters et Setters
}

