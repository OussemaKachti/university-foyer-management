package com.example.project.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    private Long numeroChambre;

    private Long capacite;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
