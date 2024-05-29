package com.s1511.Ticketcine.domain.services;
import com.s1511.Ticketcine.application.dto.mercadopago.RequestTicketDto;
import com.s1511.Ticketcine.application.dto.ticket.ResponseTicketDto;
import java.util.List;

public interface TicketService {

    String createTicket(RequestTicketDto requestTicketDto);
    List<ResponseTicketDto> getAllTicketsByUserId(String userId);
    ResponseTicketDto getTicketById(String id);


}
