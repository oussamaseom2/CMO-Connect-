package com.cmoconnect.backendweb.repository;

import com.cmoconnect.backendweb.model.PaymentsAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentAbonnementRepository extends JpaRepository<PaymentsAbonnement, Long> {
    List<PaymentsAbonnement> findByUtilisateurId(Long utilisateurId);
}
