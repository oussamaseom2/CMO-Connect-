package com.cmoconnect.backendweb.service;


import com.cmoconnect.backendweb.model.Abonnement;
import com.cmoconnect.backendweb.repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbonnementService {

    @Autowired
    private AbonnementRepository abonnementRepository;

    public Abonnement createAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }
}

