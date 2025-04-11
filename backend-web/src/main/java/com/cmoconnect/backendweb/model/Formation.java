package com.cmoconnect.backendweb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Formation {

    // Getters et Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapitre> chapitres; // Liste des chapitres associés à la formation

    private String titre;  // Titre de la formation
    private String description;  // Description de la formation
    private Integer duree;  // Durée de la formation en heures
    private Integer nbreChapitre;  // Nombre de chapitres
    private String type;  // Type de formation (e.g., en ligne, en présentiel)
    private Double prix;  // Prix de la formation
    private Boolean eSatisfait;  // Indicateur de satisfaction de la formation
    private Integer nbreInscription;  // Nombre d'inscriptions à la formation
    private String quiz;  // Quiz associé à la formation


    // Optionnel: méthode toString pour faciliter la lecture des objets
    @Override
    public String toString() {
        return "Formation{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", duree=" + duree +
                ", nbreChapitre=" + nbreChapitre +
                ", type='" + type + '\'' +
                ", prix=" + prix +
                ", eSatisfait=" + eSatisfait +
                ", nbreInscription=" + nbreInscription +
                ", quiz='" + quiz + '\'' +
                '}';
    }
}
