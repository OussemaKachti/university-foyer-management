package com.example.project.services;

import com.example.project.Entities.Reservation;
import java.util.List;

public interface IReservation {
    Reservation create(Reservation reservation);
    Reservation update(String id, Reservation reservation);
    void delete(String id);
    List<Reservation> getAll();
    Reservation getById(String id);
    Reservation ajouterReservation(long idBloc, long cinEtudiant);
    Reservation annulerReservation(long cinEtudiant);
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(java.util.Date anneeUniversite, String nomUniversite);
}
