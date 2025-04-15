package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.Utilisateur;
import com.cmoconnect.backendweb.model.UtilisateurRole;
import com.cmoconnect.backendweb.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            if (utilisateur.getEmail() == null || utilisateur.getPassword() == null) {
                return ResponseEntity.badRequest().build();
            }
            Utilisateur created = utilisateurService.createUtilisateur(utilisateur);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        try {
            List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
            return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        try {
            return utilisateurService.getUtilisateurById(id)
                    .map(utilisateur -> new ResponseEntity<>(utilisateur, HttpStatus.OK))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        try {
            if (utilisateur.getEmail() == null || utilisateur.getPassword() == null) {
                return ResponseEntity.badRequest().build();
            }
            Utilisateur updated = utilisateurService.updateUtilisateur(id, utilisateur);
            if (updated != null) {
                return new ResponseEntity<>(updated, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        try {
            if (utilisateurService.getUtilisateurById(id).isPresent()) {
                utilisateurService.deleteUtilisateur(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Utilisateur> getUtilisateurByEmail(@PathVariable String email) {
        try {
            Utilisateur utilisateur = utilisateurService.getUtilisateurByEmail(email);
            if (utilisateur != null) {
                return new ResponseEntity<>(utilisateur, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByRole(@PathVariable String role) {
        try {
            List<Utilisateur> utilisateurs = utilisateurService.getUtilisateursByRole(role);
            return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/actif/{estActif}")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByEstActif(@PathVariable Boolean estActif) {
        try {
            List<Utilisateur> utilisateurs = utilisateurService.getUtilisateursByEstActif(estActif);
            return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
