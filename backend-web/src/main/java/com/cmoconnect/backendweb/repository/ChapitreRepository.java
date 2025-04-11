package com.cmoconnect.backendweb.repository;

import com.cmoconnect.backendweb.model.Chapitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapitreRepository extends JpaRepository<Chapitre, Long> {
    List<Chapitre> findByFormationId(Long formationId);
}
