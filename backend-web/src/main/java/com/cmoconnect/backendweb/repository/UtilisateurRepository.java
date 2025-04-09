package com.cmoconnect.backendweb.repository;

import com.cmoconnect.backendweb.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
    Utilisateur findByNomAndPrenom(String nom, String prenom);
}
