package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String password;
    private Date dateInscription;
    private Date derniereDateConn;
    private String tel;
    private String photo;
    private String cv;
    private String autoProvider;

    @ElementCollection
    private List<String> portFolios;

    @Enumerated(EnumType.STRING)
    private UtilisateurRole role;

    @ManyToMany(mappedBy = "utilisateursRecommandes")
    private Set<Recommendation> recommandations;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDerniereDateConn() {
        return derniereDateConn;
    }

    public void setDerniereDateConn(Date derniereDateConn) {
        this.derniereDateConn = derniereDateConn;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getAutoProvider() {
        return autoProvider;
    }

    public void setAutoProvider(String autoProvider) {
        this.autoProvider = autoProvider;
    }

    public List<String> getPortFolios() {
        return portFolios;
    }

    public void setPortFolios(List<String> portFolios) {
        this.portFolios = portFolios;
    }

    public UtilisateurRole getRole() {
        return role;
    }

    public void setRole(UtilisateurRole role) {
        this.role = role;
    }

    public Set<Recommendation> getRecommandations() {
        return recommandations;
    }

    public void setRecommandations(Set<Recommendation> recommandations) {
        this.recommandations = recommandations;
    }
}

