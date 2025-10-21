package com.example.project.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    private String idReservation;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;

    private Boolean estValide;

    @ManyToMany
    private List<Etudiant> etudiants;
}
