package com.cmoconnect.backendweb.controller;

import com.cmoconnect.backendweb.model.CommentFormation;
import com.cmoconnect.backendweb.service.CommentFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentFormationController {

    @Autowired
    private CommentFormationService commentFormationService;

    @PostMapping("/")
    public CommentFormation createComment(@RequestBody CommentFormation commentFormation) {
        return commentFormationService.createComment(commentFormation);
    }
}