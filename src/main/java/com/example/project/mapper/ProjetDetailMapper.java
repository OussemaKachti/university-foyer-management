package com.example.project.mapper;

import com.example.project.DTO.ProjectDetailsDTO;
import com.example.project.Entities.ProjetDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface ProjetDetailMapper {

    @Mapping(source = "dateDebut", target = "dateDebut", qualifiedByName = "localDateToString")
    ProjectDetailsDTO toDto(ProjetDetail projetDetail);

    @Named("localDateToString")
    default String localDateToString(LocalDate date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
}

