package com.s1511.ticketcine.application.mapper;

import java.util.List;

import com.s1511.ticketcine.application.dto.seat.RequestSeatDto;
import com.s1511.ticketcine.application.dto.seat.ResponseSeatDto;
import org.mapstruct.Mapper;
import com.s1511.ticketcine.domain.entities.Seat;

@Mapper(componentModel = "spring")
public interface SeatMapper {

    ResponseSeatDto SeatToResponse (Seat seat);
    Seat RequestToSeat (RequestSeatDto seatDTO);
    List<ResponseSeatDto> listSeatToListResponse(List<Seat> seats);
}
