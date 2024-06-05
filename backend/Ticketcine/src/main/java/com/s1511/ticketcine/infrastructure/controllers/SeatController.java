package com.s1511.ticketcine.infrastructure.controllers;

import com.s1511.ticketcine.application.dto.seat.MultiSeatDTO;
import com.s1511.ticketcine.domain.entities.Seat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.s1511.ticketcine.application.dto.seat.SeatDTO;
import com.s1511.ticketcine.application.dto.seat.SeatReservationDTO;
import com.s1511.ticketcine.domain.services.SeatService;

import java.util.List;
import java.util.Optional;

@Tag(name = "Seat", description = "Manage all endpoints about seat")
@RequiredArgsConstructor
@RestController
@RequestMapping("/seat")
public class SeatController {

    private final SeatService seatService;

    @Operation(summary = "Get all seats", description = "Get all seats")
    @GetMapping("/all")
    public List<SeatDTO> getAllSeats() {
        return seatService.findAllSeats();
    }

    @Operation(summary = "Get a seat by id", description = "Get a seat by id")
    @GetMapping("/{id}")
    public SeatDTO getSeatById(@PathVariable String id) {
        return seatService.findSeatById(id);
    }

    @Operation(summary = "Get reserved seats by user id", description = "Get reserved seats by user id")
    @GetMapping("/reserved/{userId}")
    public List<SeatDTO> getReservedSeatsByUserId(@PathVariable String userId) {
        return seatService.findReservedSeatsByUserId(userId);
    }

    @Operation(summary = "Reserve a seat", description = "Reserve a seat by a user")
    @PostMapping("/{seatId}/reserve")
    public ResponseEntity<?> reserveSeat(@PathVariable String seatId, @RequestBody SeatReservationDTO reservationDTO) {
        if (seatService.seatReservation(seatId, reservationDTO).isPresent()) {
            return ResponseEntity.ok("Seat reserved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to reserve seat");
        }
    }

    @Operation(summary = "Reserve multiple seats", description = "Reserve multiple seats by a user")
    @PostMapping("/reserveMultiple")
    public ResponseEntity<?> reserveMultipleSeats(@RequestBody MultiSeatDTO multiSeatReservationDTO) {
        List<Optional<Seat>> reservedSeats = seatService.reserveMultipleSeats(multiSeatReservationDTO);

        if (reservedSeats.stream().allMatch(Optional::isPresent)) {
            return ResponseEntity.ok("Seats reserved succesfully");
        } else if (reservedSeats.stream().noneMatch(Optional::isPresent)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to reserve any seat");
        } else {
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("Some seats were reserved successfully");
        }
    }

    @Operation(summary = "Release a seat", description = "Release a seat, change to available")
    @PostMapping("/release")
    public ResponseEntity<?> releaseSeats(@RequestBody MultiSeatDTO seatReleaseDTO) {
        List<Optional<Seat>> releasedSeats = seatService.releaseSeats(seatReleaseDTO);

        if (releasedSeats.stream().allMatch(Optional::isPresent)) {
            return ResponseEntity.ok("All seats released successfully");
        } else if (releasedSeats.stream().noneMatch(Optional::isPresent)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to release any seat");
        } else {
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("Some seats were released successfully");
        }
    }
}
