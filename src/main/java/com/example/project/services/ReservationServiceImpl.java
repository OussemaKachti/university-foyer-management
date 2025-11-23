package com.example.project.services;

import com.example.project.Entities.*;
import com.example.project.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservation {

    private final ReservationRepository reservationRepository;
    private final BlocRepository blocRepository;
    private final ChambreRepository chambreRepository;
    private final EtudiantRepository etudiantRepository;

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

    @Override
    @Transactional
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc not found with id: " + idBloc));
        
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with CIN: " + cinEtudiant));
        
        List<Chambre> chambres = chambreRepository.findByBlocIdBloc(idBloc);
        Chambre chambreDisponible = null;
        
        for (Chambre chambre : chambres) {
            long nombreReservationsValides = 0;
            if (chambre.getReservations() != null) {
                nombreReservationsValides = chambre.getReservations().stream()
                        .filter(r -> r.getEstValide() != null && r.getEstValide())
                        .count();
            }
            
            int capaciteMax = switch (chambre.getTypeC()) {
                case SIMPLE -> 1;
                case DOUBLE -> 2;
                case TRIPLE -> 3;
                default -> 0;
            };
            
            if (nombreReservationsValides < capaciteMax) {
                chambreDisponible = chambre;
                break;
            }
        }
        
        if (chambreDisponible == null) {
            throw new RuntimeException("Aucune chambre disponible dans ce bloc");
        }
        
        Reservation reservation = new Reservation();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String annee = sdf.format(new Date());
        String idReservation = chambreDisponible.getNumeroChambre() + "-" + 
                              bloc.getNomBloc() + "-" + annee;
        reservation.setIdReservation(idReservation);
        
        reservation.setAnneeUniversitaire(new Date());
        reservation.setEstValide(true);
        
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(etudiant);
        reservation.setEtudiants(etudiants);
        
        List<Reservation> reservationsChambre = chambreDisponible.getReservations();
        if (reservationsChambre == null) {
            reservationsChambre = new ArrayList<>();
        }
        reservationsChambre.add(reservation);
        chambreDisponible.setReservations(reservationsChambre);
        
        Reservation savedReservation = reservationRepository.save(reservation);
        chambreRepository.save(chambreDisponible);
        
        return savedReservation;
    }

    @Override
    @Transactional
    public Reservation annulerReservation(long cinEtudiant) {
        Reservation reservation = reservationRepository.findByEtudiantsCinAndEstValide(cinEtudiant, true)
                .orElseThrow(() -> new RuntimeException("Aucune réservation valide trouvée pour l'étudiant avec CIN: " + cinEtudiant));
        
        reservation.setEstValide(false);
        
        if (reservation.getEtudiants() != null) {
            reservation.getEtudiants().clear();
        }
        
        List<Chambre> toutesChambres = chambreRepository.findAll();
        for (Chambre chambre : toutesChambres) {
            if (chambre.getReservations() != null && chambre.getReservations().contains(reservation)) {
                chambre.getReservations().remove(reservation);
                chambreRepository.save(chambre);
                break;
            }
        }
        
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        List<Reservation> toutesReservations = reservationRepository.findAll();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(anneeUniversite);
        int anneeRecherchee = cal.get(java.util.Calendar.YEAR);
        
        List<Chambre> chambresUniversite = chambreRepository.findByBlocFoyerUniversiteNomUniversite(nomUniversite);
        
        return toutesReservations.stream()
            .filter(r -> {
                if (r.getAnneeUniversitaire() == null) return false;
                cal.setTime(r.getAnneeUniversitaire());
                int anneeReservation = cal.get(java.util.Calendar.YEAR);
                return anneeReservation == anneeRecherchee;
            })
            .filter(r -> chambresUniversite.stream()
                .anyMatch(c -> c.getReservations() != null && c.getReservations().contains(r)))
            .distinct()
            .collect(java.util.stream.Collectors.toList());
    }
}
