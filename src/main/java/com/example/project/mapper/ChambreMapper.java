package com.example.project.mapper;

import com.example.project.DTO.ChambreDTO;
import com.example.project.Entities.Chambre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChambreMapper {
    ChambreDTO toDto(Chambre chambre);
    Chambre toEntity(ChambreDTO chambreDTO);
}

