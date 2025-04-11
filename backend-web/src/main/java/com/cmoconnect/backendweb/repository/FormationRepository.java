package com.cmoconnect.backendweb.repository;

import com.cmoconnect.backendweb.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
    List<Formation> findByType(String type);
    List<Formation> findByPrixLessThan(Double prix);
    List<Formation> findByeSatisfait(Boolean eSatisfait);
}

