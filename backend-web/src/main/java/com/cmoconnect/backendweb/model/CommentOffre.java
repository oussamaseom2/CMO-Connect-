package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CommentOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    private String contenu;  // Contenu du commentaire
    private Date datePublication;  // Date de publication du commentaire
    private Date dateModification;  // Date de modification du commentaire
    private Boolean estActive;  // Indique si le commentaire est actif

    // Getters et Setters
}
