package com.cmoconnect.backendweb.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CommentFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;  // Utilisateur qui a commenté la formation

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;  // Formation associée au commentaire

    private String contenu;  // Contenu du commentaire
    private Date datePublication;  // Date de publication du commentaire
    private Date dateModification;  // Date de modification du commentaire
    private Boolean estActive;  // Indicateur si le commentaire est actif

    // Getters et Setters
}
