package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.Formation;
import com.cmoconnect.backendweb.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class FormationController {

    @Autowired
    private FormationService formationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Formation> createFormation(@RequestBody Formation formation) {
        Formation created = formationService.createFormation(formation);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Formation>> getAllFormations() {
        List<Formation> formations = formationService.getAllFormations();
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Formation> getFormationById(@PathVariable Long id) {
        Formation formation = formationService.getFormationById(id);
        if (formation != null) {
            return new ResponseEntity<>(formation, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Formation> updateFormation(@PathVariable Long id, @RequestBody Formation formation) {
        try {
            Formation updated = formationService.updateFormation(id, formation);
            if (updated != null) {
                return new ResponseEntity<>(updated, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        try {
            Formation formation = formationService.getFormationById(id);
            if (formation != null) {
                formationService.deleteFormation(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/type/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Formation>> getFormationsByType(@PathVariable String type) {
        List<Formation> formations = formationService.getFormationsByType(type);
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    @GetMapping(value = "/prix/{prix}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Formation>> getFormationsByPrixLessThan(@PathVariable Double prix) {
        List<Formation> formations = formationService.getFormationsByPrixLessThan(prix);
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    @GetMapping(value = "/satisfaction/{eSatisfait}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Formation>> getFormationsByeSatisfait(@PathVariable Boolean eSatisfait) {
        List<Formation> formations = formationService.getFormationsByeSatisfait(eSatisfait);
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }
}