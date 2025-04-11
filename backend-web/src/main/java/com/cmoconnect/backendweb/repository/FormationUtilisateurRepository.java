package com.cmoconnect.backendweb.repository;

import com.cmoconnect.backendweb.model.FormationUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationUtilisateurRepository extends JpaRepository<FormationUtilisateur, Long> {
    List<FormationUtilisateur> findByUtilisateurId(Long utilisateurId);
    List<FormationUtilisateur> findByFormationId(Long formationId);
} 