package com.example.project.repository;

import com.example.project.Entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
