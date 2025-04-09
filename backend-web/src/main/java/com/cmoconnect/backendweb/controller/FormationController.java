package com.cmoconnect.backendweb.controller;


import com.cmoconnect.backendweb.model.Formation;
import com.cmoconnect.backendweb.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
public class FormationController {

    @Autowired
    private FormationService formationService;

    @GetMapping("/")
    public List<Formation> getAllFormations() {
        return formationService.getAllFormations();
    }

    @PostMapping("/")
    public Formation createFormation(@RequestBody Formation formation) {
        return formationService.createFormation(formation);
    }
}