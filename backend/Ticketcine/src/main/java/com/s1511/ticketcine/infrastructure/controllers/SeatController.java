package com.s1511.ticketcine.infrastructure.controllers;

import com.s1511.ticketcine.application.dto.seat.RequestSeatDto;
import com.s1511.ticketcine.application.dto.seat.ResponseSeatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.s1511.ticketcine.domain.entities.Seat;
import com.s1511.ticketcine.domain.services.SeatService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seats")
public class SeatController {/*

    private final SeatService seatService;

    @GetMapping("/all")
    public List<ResponseSeatDto> getAllSeats() {
        return seatService.findAllSeats();
    }

    @GetMapping("/{id}")
    public ResponseSeatDto getSeatById(@PathVariable Long id) {
        return seatService.findSeatById(id);
    }

    @PutMapping("/{id}/reserve")
    public ResponseEntity<String> reserveSeat(@PathVariable Long id, @RequestBody RequestSeatDto seatReservationDTO) {
        Optional<Seat> reservedSeat = seatService.seatReservation(id, seatReservationDTO);

        if (reservedSeat.isPresent()) {
            return ResponseEntity.ok("Seat reserved successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Seat is already reserved or not found.");
        }
    }
*/
}
