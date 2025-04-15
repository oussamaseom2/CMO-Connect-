package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.TypePayAbonnement;
import com.cmoconnect.backendweb.service.TypePayAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type-pay-abonnements")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class TypePayAbonnementController {
    @Autowired
    private TypePayAbonnementService typePayAbonnementService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TypePayAbonnement> createTypePayAbonnement(@RequestBody TypePayAbonnement typePayAbonnement) {
        TypePayAbonnement created = typePayAbonnementService.createTypePayAbonnement(typePayAbonnement);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TypePayAbonnement>> getAllTypePayAbonnements() {
        List<TypePayAbonnement> typePayAbonnements = typePayAbonnementService.getAllTypePayAbonnements();
        return new ResponseEntity<>(typePayAbonnements, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TypePayAbonnement> getTypePayAbonnementById(@PathVariable Long id) {
        Optional<TypePayAbonnement> typePayAbonnement = typePayAbonnementService.getTypePayAbonnementById(id);
        return typePayAbonnement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TypePayAbonnement> updateTypePayAbonnement(@PathVariable Long id, @RequestBody TypePayAbonnement typePayAbonnement) {
        TypePayAbonnement updated = typePayAbonnementService.updateTypePayAbonnement(id, typePayAbonnement);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypePayAbonnement(@PathVariable Long id) {
        Optional<TypePayAbonnement> typePayAbonnement = typePayAbonnementService.getTypePayAbonnementById(id);
        if (typePayAbonnement.isPresent()) {
            typePayAbonnementService.deleteTypePayAbonnement(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/actif/{estActif}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TypePayAbonnement>> getTypePayAbonnementsByEstActif(@PathVariable Boolean estActif) {
        List<TypePayAbonnement> typePayAbonnements = typePayAbonnementService.getTypePayAbonnementsByEstActif(estActif);
        return new ResponseEntity<>(typePayAbonnements, HttpStatus.OK);
    }
} 