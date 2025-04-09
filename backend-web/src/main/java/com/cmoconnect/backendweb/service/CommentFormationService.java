package com.cmoconnect.backendweb.service;

import com.cmoconnect.backendweb.model.CommentFormation;
import com.cmoconnect.backendweb.repository.CommentFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentFormationService {

    @Autowired
    private CommentFormationRepository commentFormationRepository;

    public CommentFormation createComment(CommentFormation commentFormation) {
        return commentFormationRepository.save(commentFormation);
    }
}
