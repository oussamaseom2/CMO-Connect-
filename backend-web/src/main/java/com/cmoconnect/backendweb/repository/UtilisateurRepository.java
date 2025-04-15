package com.cmoconnect.backendweb.repository;

import com.cmoconnect.backendweb.model.Utilisateur;
import com.cmoconnect.backendweb.model.UtilisateurRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String email); // ✅ champ existant

    List<Utilisateur> findByRole(UtilisateurRole role); // ✅ enum correct

    List<Utilisateur> findByEstActif(Boolean estActif); // ✅ maintenant que le champ existe
}
