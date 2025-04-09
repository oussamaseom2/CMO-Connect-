package com.cmoconnect.backendweb.service;


import com.cmoconnect.backendweb.model.Formation;
import com.cmoconnect.backendweb.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;

    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }
}