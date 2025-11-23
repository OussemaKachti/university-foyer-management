package com.example.project.repository;

import com.example.project.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    Optional<Reservation> findByEtudiantsCinAndEstValide(Long cin, Boolean estValide);
}
