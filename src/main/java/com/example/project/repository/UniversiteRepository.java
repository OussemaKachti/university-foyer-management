package com.example.project.repository;

import com.example.project.Entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    Optional<Universite> findByNomUniversite(String nomUniversite);
}
