package com.example.project.mapper;

import com.example.project.DTO.EtudiantDTO;
import com.example.project.Entities.Etudiant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {
    EtudiantDTO toDto(Etudiant etudiant);
    Etudiant toEntity(EtudiantDTO etudiantDTO);
}

