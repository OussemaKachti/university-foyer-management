package com.example.project.mapper;

import com.example.project.DTO.BlocDTO;
import com.example.project.Entities.Bloc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlocMapper {
    BlocDTO toDto(Bloc bloc);
    Bloc toEntity(BlocDTO blocDTO);
}

