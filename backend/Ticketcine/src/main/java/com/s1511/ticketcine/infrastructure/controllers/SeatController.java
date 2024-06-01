package com.s1511.ticketcine.infrastructure.controllers;

import com.s1511.ticketcine.application.dto.seat.SeatReleaseRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.s1511.ticketcine.application.dto.seat.SeatDTO;
import com.s1511.ticketcine.application.dto.seat.SeatReservationDTO;
import com.s1511.ticketcine.domain.services.SeatService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seat")
public class SeatController {

    private final SeatService seatService;

    @GetMapping("/all")
    public List<SeatDTO> getAllSeats() {
        return seatService.findAllSeats();
    }

    @GetMapping("/{id}")
    public SeatDTO getSeatById(@PathVariable String id) {
        return seatService.findSeatById(id);
    }

    @GetMapping("/reserved/{userId}")
    public List<SeatDTO> getReservedSeatsByUserId(@PathVariable String userId) {
        return seatService.findReservedSeatsByUserId(userId);
    }

    @PostMapping("/{seatId}/reserve")
    public ResponseEntity<?> reserveSeat(@PathVariable String seatId, @RequestBody SeatReservationDTO reservationDTO) {
        if (seatService.seatReservation(seatId, reservationDTO).isPresent()) {
            return ResponseEntity.ok("Seat reserved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to reserve seat");
        }
    }

    @PostMapping("/release")
    public  ResponseEntity<String> releaseReservedSeats (@RequestBody SeatReleaseRequestDTO seatReleaseRequestDTO) {
        if (seatService.releaseReservedSeats(seatReleaseRequestDTO)){
            return ResponseEntity.ok("Seats succesfully released");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to release seats");
        }
    }
}
