package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

@Entity
public class Condidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private TypeOffre offre;

    @Enumerated(EnumType.STRING)
    private CondidatureStatus status;

    private Date datePostulation;
    private Date dateResponse;

    private Boolean estArchiveEntreprise;  // Indique si la candidature a été archivée par l'entreprise
    private Boolean estArchiveCondidature;  // Indique si la candidature a été archivée par le candidat

    // Getters et Setters
}
