package com.example.project.DTO;

import com.example.project.Entities.TypeChambre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDTO {
    private Long numeroChambre;
    private Long capacite;
    private TypeChambre typeC;
}

