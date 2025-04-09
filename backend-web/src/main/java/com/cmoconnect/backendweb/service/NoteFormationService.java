package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.NoteFormation;
import com.cmoconnect.backendweb.repository.NoteFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteFormationService {

    @Autowired
    private NoteFormationRepository noteFormationRepository;

    public NoteFormation createNoteFormation(NoteFormation noteFormation) {
        return noteFormationRepository.save(noteFormation);
    }
}