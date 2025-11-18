package com.example.project.mapper;

import com.example.project.DTO.ReservationDTO;
import com.example.project.Entities.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    Reservation toEntity(ReservationDTO dto);

    ReservationDTO toDto(Reservation reservation);
}


