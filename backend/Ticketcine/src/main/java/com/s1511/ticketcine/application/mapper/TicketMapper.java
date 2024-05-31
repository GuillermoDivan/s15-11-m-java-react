package com.s1511.ticketcine.application.mapper;

import com.s1511.ticketcine.application.dto.ticket.ResponseTicketDto;
import com.s1511.ticketcine.domain.entities.Seat;
import com.s1511.ticketcine.domain.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

    @Mapper(componentModel = "spring")
    public abstract class TicketMapper {

        @Mapping(target = "seatsIds", source = "seatsIds")
        public abstract ResponseTicketDto ticketToResponseDto (Ticket ticket);
        public abstract List<ResponseTicketDto> ticketListToResponseDtoList (List<Ticket> ticketList);

        public String seatToString(Seat seat){
            return seat.getSeatNumber();
        }


    }
