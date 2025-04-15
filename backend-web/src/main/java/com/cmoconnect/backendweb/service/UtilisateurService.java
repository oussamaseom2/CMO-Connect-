package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.Utilisateur;
import com.cmoconnect.backendweb.model.UtilisateurRole;
import com.cmoconnect.backendweb.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        if (utilisateur.getEmail() == null || utilisateur.getPassword() == null) {
            throw new IllegalArgumentException("Email and password are required");
        }
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur) {
        if (utilisateur.getEmail() == null || utilisateur.getPassword() == null) {
            throw new IllegalArgumentException("Email and password are required");
        }
        if (utilisateurRepository.existsById(id)) {
            utilisateur.setId(id);
            return utilisateurRepository.save(utilisateur);
        }
        return null;
    }

    public void deleteUtilisateur(Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        utilisateurRepository.deleteById(id);
    }

    public Utilisateur getUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public List<Utilisateur> getUtilisateursByRole(String role) {
        try {
            UtilisateurRole enumRole = UtilisateurRole.valueOf(role.toUpperCase());
            return utilisateurRepository.findByRole(enumRole);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    public List<Utilisateur> getUtilisateursByEstActif(Boolean estActif) {
        return utilisateurRepository.findByEstActif(estActif);
    }
}
