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
    public class Foyer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idFoyer;

        private String nomFoyer;

        private Long capaciteFoyer;

        @OneToOne(mappedBy = "foyer")
        private Universite universite;

        @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL)
        private List<Bloc> blocs;
    }