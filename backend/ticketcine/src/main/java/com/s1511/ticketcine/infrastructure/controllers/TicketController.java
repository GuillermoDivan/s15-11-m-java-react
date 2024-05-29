package com.s1511.ticketcine.infrastructure.controllers;

import com.s1511.ticketcine.application.dto.ticket.ResponseTicketDto;
import com.s1511.ticketcine.domain.services.TicketService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ticket")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class TicketController {
    public final TicketService ticketService;

    @GetMapping("/u/{userId}/{active}")
    public List<ResponseTicketDto> getAllTicketsByUserIdAndActive (@PathVariable String userId, @PathVariable Boolean active) {
        return ticketService.getAllTicketsByUserIdAndActive(userId, active);
    }

    @GetMapping("/{id}")
    public ResponseTicketDto getTicketById (@PathVariable String id) {
        return ticketService.getTicketById(id);
    }
}
