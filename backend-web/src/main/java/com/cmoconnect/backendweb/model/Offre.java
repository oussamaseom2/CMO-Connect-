package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateurEntreprise_id")
    private Utilisateur utilisateurEntreprise;  // Utilisateur entreprise qui a créé l'offre

    private String titre;  // Titre de l'offre
    private String description;  // Description de l'offre
    private String typeOffre;  // Type d'offre (e.g., plein temps, contrat, etc.)
    private String localisation;  // Localisation de l'offre
    private Double prix;  // Prix de l'offre (ou salaire proposé)
    private Date dateCreation;  // Date de création de l'offre
    private Boolean estArchivee;  // Indicateur si l'offre est archivée

    @OneToMany(mappedBy = "offre")
    private List<CompetenceRequired> competencesRequired;  // Compétences requises pour l'offre

    @OneToMany(mappedBy = "offre")
    private List<CommentOffre> commentaires;  // Commentaires associés à l'offre

    @OneToMany(mappedBy = "offre")
    private List<ReactionOffre> reactions;  // Réactions des utilisateurs sur l'offre

    @OneToMany(mappedBy = "offre")
    private List<FavoriteOffre> favoriteOffres;  // Favoris de l'offre par les utilisateurs

    // Getters et Setters
}
