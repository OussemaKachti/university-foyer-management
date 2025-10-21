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
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String nomEt;

    private String prenomEt;

    private Long cin;

    private String ecole;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @ManyToMany(mappedBy = "etudiants")
    private List<Reservation> reservations;
}