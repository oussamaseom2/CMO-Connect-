package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.Abonnement;
import com.cmoconnect.backendweb.service.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abonnements")
public class AbonnementController {

    @Autowired
    private AbonnementService abonnementService;

    @PostMapping("/")
    public ResponseEntity<Abonnement> createAbonnement(@RequestBody Abonnement abonnement) {
        return ResponseEntity.ok(abonnementService.createAbonnement(abonnement));
    }

    @GetMapping("/")
    public ResponseEntity<List<Abonnement>> getAllAbonnements() {
        return ResponseEntity.ok(abonnementService.getAllAbonnements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abonnement> getAbonnementById(@PathVariable Long id) {
        return ResponseEntity.ok(abonnementService.getAbonnementById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abonnement> updateAbonnement(@PathVariable Long id, @RequestBody Abonnement abonnement) {
        return ResponseEntity.ok(abonnementService.updateAbonnement(id, abonnement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbonnement(@PathVariable Long id) {
        abonnementService.deleteAbonnement(id);
        return ResponseEntity.ok().build();
    }
}