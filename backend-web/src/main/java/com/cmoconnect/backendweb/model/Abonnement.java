package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;  // Utilisateur ayant l'abonnement

    @ManyToOne
    @JoinColumn(name = "typePayAbonnement_id")
    private TypePayAbonnement typePayAbonnement;  // Type d'abonnement (payant ou gratuit)

    private Float prixTotal;  // Prix total de l'abonnement
    private Date dateDebut;  // Date de début de l'abonnement
    private Date dateFin;  // Date de fin de l'abonnement
    private Boolean renouvellementAutomatique;  // Indicateur du renouvellement automatique

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public TypePayAbonnement getTypePayAbonnement() {
        return typePayAbonnement;
    }

    public void setTypePayAbonnement(TypePayAbonnement typePayAbonnement) {
        this.typePayAbonnement = typePayAbonnement;
    }

    public Float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getRenouvellementAutomatique() {
        return renouvellementAutomatique;
    }

    public void setRenouvellementAutomatique(Boolean renouvellementAutomatique) {
        this.renouvellementAutomatique = renouvellementAutomatique;
    }
}
