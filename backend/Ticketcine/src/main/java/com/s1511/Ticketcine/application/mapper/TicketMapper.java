package com.s1511.Ticketcine.application.mapper;

import com.s1511.Ticketcine.application.dto.ticket.ResponseTicketDto;
import com.s1511.Ticketcine.domain.entities.Seat;
import com.s1511.Ticketcine.domain.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TicketMapper {

    @Mapping(target = "seatsNames", source = "seatsNames")
    public abstract ResponseTicketDto ticketToResponseDto (Ticket ticket);
    public abstract List<ResponseTicketDto> ticketListToResponseDtoList (List<Ticket> ticketList);

    public String seatToString(Seat seat){
        return seat.getSeatNumber();
    }



}
