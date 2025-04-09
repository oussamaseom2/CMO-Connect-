package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.NoteFormation;
import com.cmoconnect.backendweb.service.NoteFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
public class NoteFormationController {
    @Autowired
    private NoteFormationService noteFormationService;

    @PostMapping("/")
    public NoteFormation createNoteFormation(@RequestBody NoteFormation noteFormation) {
        return noteFormationService.createNoteFormation(noteFormation);
    }
}
