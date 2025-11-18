package com.example.project.controller;

import com.example.project.DTO.ReservationDTO;
import com.example.project.Entities.Reservation;
import com.example.project.mapper.ReservationMapper;
import com.example.project.services.IReservation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final IReservation ireservation;
    private final ReservationMapper reservationMapper;

    @PostMapping("/create")
    public ReservationDTO create(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        Reservation createdReservation = ireservation.create(reservation);
        return reservationMapper.toDto(createdReservation);
    }

     @PutMapping("/update/{id}")
     public Reservation update(@PathVariable String id, @RequestBody Reservation reservation) {
         return ireservation.update(id, reservation);
     }
    
     @DeleteMapping("/delete/{id}")
     public void delete(@PathVariable String id) {
         ireservation.delete(id);
     }

     @GetMapping("/getById/{id}")
     public Reservation getById(@PathVariable String id) {
         return ireservation.getById(id);
     }

     @GetMapping("/getAll")
     public List<Reservation> getAll() {
         return ireservation.getAll();
     }
}
