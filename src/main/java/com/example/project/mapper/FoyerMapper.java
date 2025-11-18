package com.example.project.mapper;

import com.example.project.DTO.FoyerDTO;
import com.example.project.Entities.Foyer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoyerMapper {
    FoyerDTO toDto(Foyer foyer);
    Foyer toEntity(FoyerDTO foyerDTO);
}

