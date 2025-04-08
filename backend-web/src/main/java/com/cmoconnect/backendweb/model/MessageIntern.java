package com.cmoconnect.backendweb.model;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
public class MessageIntern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenu;
    private Date dateMessage;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "utilisateurDestinataire_id")
    private Utilisateur utilisateurDestinataire;

    // Getters et Setters
}
