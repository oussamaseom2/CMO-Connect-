package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.TypePayAbonnement;
import com.cmoconnect.backendweb.repository.TypePayAbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypePayAbonnementService {

    @Autowired
    private TypePayAbonnementRepository typePayAbonnementRepository;

    public TypePayAbonnement createTypePayAbonnement(TypePayAbonnement typePayAbonnement) {
        return typePayAbonnementRepository.save(typePayAbonnement);
    }

    public List<TypePayAbonnement> getAllTypePayAbonnements() {
        return typePayAbonnementRepository.findAll();
    }

    public Optional<TypePayAbonnement> getTypePayAbonnementById(Long id) {
        return typePayAbonnementRepository.findById(id);
    }

    public TypePayAbonnement updateTypePayAbonnement(Long id, TypePayAbonnement typePayAbonnement) {
        if (typePayAbonnementRepository.existsById(id)) {
            typePayAbonnement.setId(id);
            return typePayAbonnementRepository.save(typePayAbonnement);
        }
        return null;
    }

    public void deleteTypePayAbonnement(Long id) {
        typePayAbonnementRepository.deleteById(id);
    }

    public List<TypePayAbonnement> getTypePayAbonnementsByEstActif(Boolean estActif) {
        return typePayAbonnementRepository.findByEstActif(estActif);
    }
}