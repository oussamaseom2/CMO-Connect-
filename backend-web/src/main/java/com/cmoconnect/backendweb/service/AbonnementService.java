package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.Abonnement;
import com.cmoconnect.backendweb.repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementService {

    @Autowired
    private AbonnementRepository abonnementRepository;

    public Abonnement createAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    public Abonnement getAbonnementById(Long id) {
        return abonnementRepository.findById(id).orElse(null);
    }

    public Abonnement updateAbonnement(Long id, Abonnement abonnement) {
        if (abonnementRepository.existsById(id)) {
            abonnement.setId(id);
            return abonnementRepository.save(abonnement);
        }
        return null;
    }

    public void deleteAbonnement(Long id) {
        abonnementRepository.deleteById(id);
    }

    public List<Abonnement> getAbonnementsByUtilisateur(Long utilisateurId) {
        return abonnementRepository.findByUtilisateurId(utilisateurId);
    }
}

