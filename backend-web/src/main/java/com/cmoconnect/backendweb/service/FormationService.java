package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.Formation;
import com.cmoconnect.backendweb.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;

    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    public Formation getFormationById(Long id) {
        return formationRepository.findById(id).orElse(null);
    }

    public Formation updateFormation(Long id, Formation formation) {
        Optional<Formation> existingFormation = formationRepository.findById(id);
        if (existingFormation.isPresent()) {
            formation.setId(id);
            return formationRepository.save(formation);
        }
        return null;
    }

    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }

    public List<Formation> getFormationsByType(String type) {
        return formationRepository.findByType(type);
    }

    public List<Formation> getFormationsByPrixLessThan(Double prix) {
        return formationRepository.findByPrixLessThan(prix);
    }

    public List<Formation> getFormationsByeSatisfait(Boolean eSatisfait) {
        return formationRepository.findByeSatisfait(eSatisfait);
    }
}