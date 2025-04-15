package com.cmoconnect.backendweb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", nullable = false, updatable = false)
private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private Boolean estActif = true;

    private String tel;

    private String photo;

    private String cv;

    private String autoProvider = "local";

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "utilisateur_portfolios", joinColumns = @JoinColumn(name = "utilisateur_id"))
    @Column(name = "portfolio_url")
    private List<String> portFolios = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UtilisateurRole role = UtilisateurRole.USER;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateInscription = new Date();

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date derniereDateConn = new Date();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "utilisateur_recommendation",
        joinColumns = @JoinColumn(name = "utilisateur_id"),
        inverseJoinColumns = @JoinColumn(name = "recommendation_id")
    )
    private Set<Recommendation> recommandations = new HashSet<>();

    // Default constructor
    public Utilisateur() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstActif() {
        return estActif;
    }

    public void setEstActif(Boolean estActif) {
        this.estActif = estActif;
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
        this.portFolios = portFolios != null ? portFolios : new ArrayList<>();
    }

    public UtilisateurRole getRole() {
        return role;
    }

    public void setRole(UtilisateurRole role) {
        this.role = role;
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

    public Set<Recommendation> getRecommandations() {
        return recommandations;
    }

    public void setRecommandations(Set<Recommendation> recommandations) {
        this.recommandations = recommandations != null ? recommandations : new HashSet<>();
    }
}
