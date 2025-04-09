package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.Abonnement;
import com.cmoconnect.backendweb.service.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/abonnements")
public class AbonnementController {

    @Autowired
    private AbonnementService abonnementService;

    @PostMapping("/")
    public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.createAbonnement(abonnement);
    }
}