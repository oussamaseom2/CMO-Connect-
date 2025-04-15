package com.cmoconnect.backendweb.repository;

import com.cmoconnect.backendweb.model.PaymentAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentAbonnementRepository extends JpaRepository<PaymentAbonnement, Long> {
    List<PaymentAbonnement> findByUtilisateurId(Long utilisateurId);
}
