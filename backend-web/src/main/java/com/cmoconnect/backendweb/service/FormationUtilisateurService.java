package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.FormationUtilisateur;
import com.cmoconnect.backendweb.repository.FormationUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationUtilisateurService {

    @Autowired
    private FormationUtilisateurRepository formationUtilisateurRepository;

    public FormationUtilisateur createFormationUtilisateur(FormationUtilisateur formationUtilisateur) {
        return formationUtilisateurRepository.save(formationUtilisateur);
    }

    public List<FormationUtilisateur> getAllFormationUtilisateurs() {
        return formationUtilisateurRepository.findAll();
    }

    public FormationUtilisateur getFormationUtilisateurById(Long id) {
        return formationUtilisateurRepository.findById(id).orElse(null);
    }

    public FormationUtilisateur updateFormationUtilisateur(Long id, FormationUtilisateur formationUtilisateur) {
        if (formationUtilisateurRepository.existsById(id)) {
            formationUtilisateur.setId(id);
            return formationUtilisateurRepository.save(formationUtilisateur);
        }
        return null;
    }

    public void deleteFormationUtilisateur(Long id) {
        formationUtilisateurRepository.deleteById(id);
    }

    public List<FormationUtilisateur> getFormationsByUtilisateur(Long utilisateurId) {
        return formationUtilisateurRepository.findByUtilisateurId(utilisateurId);
    }

    public List<FormationUtilisateur> getUtilisateursByFormation(Long formationId) {
        return formationUtilisateurRepository.findByFormationId(formationId);
    }
} 