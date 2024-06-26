package com.s1511.ticketcine.domain.services;
import java.util.List;

import com.s1511.ticketcine.application.dto.mercadopago.RequestTicketDto;
import com.s1511.ticketcine.application.dto.ticket.ResponseTicketDto;
import com.s1511.ticketcine.domain.entities.Ticket;

public interface TicketService {
    String createTicket(RequestTicketDto requestTicketDto);
    List<ResponseTicketDto> getAllTicketsByUserIdAndActive(String userId, Boolean active);
    List<ResponseTicketDto> getAllTicketsByUserId(String userId);
    ResponseTicketDto getTicketById(String id);
    ResponseTicketDto buyTicketWithMoviePoints(double moviePoints, RequestTicketDto requestTicketDto);


}
