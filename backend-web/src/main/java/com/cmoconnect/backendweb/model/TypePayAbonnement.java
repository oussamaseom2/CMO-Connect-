package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TypePayAbonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private Double prix;
    private Integer duree; // en jours
    private Boolean estActif;
}
