package com.example.project.repository;

import com.example.project.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByCin(Long cin);
}
