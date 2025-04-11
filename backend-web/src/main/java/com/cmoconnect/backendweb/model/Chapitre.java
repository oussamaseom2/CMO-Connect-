package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

@Entity
public class Chapitre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "formation_id")  // Assure-toi que la clé étrangère est bien définie
    private Formation formation;



    // Relier Chapitre à FormationUtilisateur avec une clé étrangère
    @ManyToOne
    @JoinColumn(name = "formation_utilisateur_id")  // Nom de la colonne de clé étrangère
    private FormationUtilisateur formationUtilisateur;  // FormationUtilisateur associé à ce chapitre

    private String titre;
    private String video;
    private String pdf;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public FormationUtilisateur getFormationUtilisateur() {
        return formationUtilisateur;
    }

    public void setFormationUtilisateur(FormationUtilisateur formationUtilisateur) {
        this.formationUtilisateur = formationUtilisateur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
}
