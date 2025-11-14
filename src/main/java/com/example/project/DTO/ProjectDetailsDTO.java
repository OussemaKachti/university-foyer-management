package com.example.project.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDetailsDTO {

    private String description;
    private String technologie;
    private String dateDebut; // Exemple: "19/07/2025" au lieu de LocalDate
}
