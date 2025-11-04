package com.example.project.services;

import com.example.project.Entities.Reservation;
import com.example.project.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservation {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(String id, Reservation reservation) {
        reservation.setIdReservation(id);
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getById(String id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }
}
