package com.example.project.repository;

import com.example.project.Entities.ProjetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetDetailRepository extends JpaRepository<ProjetDetail, Long> {
}


