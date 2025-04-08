package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

@Entity
public class FormationUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    private Float progression;  // Progrès dans la formation

    @OneToMany(mappedBy = "formationUtilisateur")
    private List<Chapter> completedChapters;  // Chapitres terminés

    private String description;  // Description de la formation
    private Date dateDebut;  // Date de début de la formation
    private Date dateFin;  // Date de fin de la formation
    private Boolean isFin;  // Indique si la formation est terminée

    // Getters et Setters
}
