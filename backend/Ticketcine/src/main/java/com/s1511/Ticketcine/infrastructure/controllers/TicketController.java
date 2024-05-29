package com.s1511.Ticketcine.infrastructure.controllers;
import com.s1511.Ticketcine.application.dto.ticket.ResponseTicketDto;
import com.s1511.Ticketcine.domain.services.TicketService;
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

    @GetMapping("/u/{userId}")
    public List<ResponseTicketDto> getAllTicketsByUserId (@PathVariable String userId) {
        return ticketService.getAllTicketsByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseTicketDto getTicketById (@PathVariable String id) {
        return ticketService.getTicketById(id);
    }
}
