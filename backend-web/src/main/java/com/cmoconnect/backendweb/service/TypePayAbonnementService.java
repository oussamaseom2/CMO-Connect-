package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.TypePayAbonnement;
import com.cmoconnect.backendweb.repository.TypePayAbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypePayAbonnementService {

    @Autowired
    private TypePayAbonnementRepository typePayAbonnementRepository;

    public TypePayAbonnement createTypePayAbonnement(TypePayAbonnement typePayAbonnement) {
        return typePayAbonnementRepository.save(typePayAbonnement);
    }
}