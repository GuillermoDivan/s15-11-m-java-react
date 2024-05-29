package com.s1511.ticketcine.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.s1511.ticketcine.application.dto.seat.SeatDTO;
import com.s1511.ticketcine.domain.entities.Seat;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SeatMapper {

    SeatDTO toDTO(Seat seat);
    Seat toEntity(SeatDTO seatDTO);
    List<SeatDTO> listEntityToDto(List<Seat> seats);
}
