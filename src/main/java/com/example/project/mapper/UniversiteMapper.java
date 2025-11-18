package com.example.project.mapper;

import com.example.project.DTO.UniversiteDTO;
import com.example.project.Entities.Universite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniversiteMapper {
    UniversiteDTO toDto(Universite universite);
    Universite toEntity(UniversiteDTO universiteDTO);
}

