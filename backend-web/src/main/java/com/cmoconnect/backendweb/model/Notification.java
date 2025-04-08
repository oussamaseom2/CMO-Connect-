package com.cmoconnect.backendweb.model;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenu;  // Contenu de la notification
    private Date dateNotification;  // Date de la notification

    // Relation ManyToOne : l'utilisateur qui reçoit la notification
    @ManyToOne
    @JoinColumn(name = "utilisateurRecevant_id")
    private Utilisateur utilisateurRecevant;

    // Relation ManyToOne : l'utilisateur qui envoie la notification
    @ManyToOne
    @JoinColumn(name = "utilisateurEnvoie_id")
    private Utilisateur utilisateurEnvoie;

    // Getters et Setters
}
