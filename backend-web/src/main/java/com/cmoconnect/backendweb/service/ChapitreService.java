package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.Chapitre;
import com.cmoconnect.backendweb.repository.ChapitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapitreService {

    @Autowired
    private ChapitreRepository chapitreRepository;

    public Chapitre createChapitre(Chapitre chapitre) {
        return chapitreRepository.save(chapitre);
    }

    public List<Chapitre> getAllChapitres() {
        return chapitreRepository.findAll();
    }

    public Chapitre getChapitreById(Long id) {
        return chapitreRepository.findById(id).orElse(null);
    }

    public Chapitre updateChapitre(Long id, Chapitre chapitre) {
        if (chapitreRepository.existsById(id)) {
            chapitre.setId(id);
            return chapitreRepository.save(chapitre);
        }
        return null;
    }

    public void deleteChapitre(Long id) {
        chapitreRepository.deleteById(id);
    }

    public List<Chapitre> getChapitresByFormation(Long formationId) {
        return chapitreRepository.findByFormationId(formationId);
    }
} 