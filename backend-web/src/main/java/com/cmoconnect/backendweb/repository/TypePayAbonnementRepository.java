package com.cmoconnect.backendweb.repository;

import com.cmoconnect.backendweb.model.TypePayAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypePayAbonnementRepository extends JpaRepository<TypePayAbonnement, Long> {
    List<TypePayAbonnement> findByEstActif(Boolean estActif);
}
