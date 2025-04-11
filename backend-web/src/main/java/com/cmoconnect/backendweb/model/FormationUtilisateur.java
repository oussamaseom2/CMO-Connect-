package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

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

    private Float progression;

    @OneToMany(mappedBy = "formationUtilisateur")
    private List<Chapitre> completedChapters;

    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Boolean isFin = false;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
    public Formation getFormation() { return formation; }
    public void setFormation(Formation formation) { this.formation = formation; }
    public Float getProgression() { return progression; }
    public void setProgression(Float progression) { this.progression = progression; }
    public List<Chapitre> getCompletedChapters() { return completedChapters; }
    public void setCompletedChapters(List<Chapitre> completedChapters) { this.completedChapters = completedChapters; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }
    public Boolean getIsFin() { return isFin; }
    public void setIsFin(Boolean isFin) { this.isFin = isFin; }
}
