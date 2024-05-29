package com.s1511.ticketcine.domain.services;

import org.springframework.stereotype.Service;

import com.s1511.ticketcine.application.dto.seat.SeatDTO;
import com.s1511.ticketcine.application.dto.seat.SeatReservationDTO;
import com.s1511.ticketcine.domain.entities.Seat;

import java.util.List;
import java.util.Optional;

@Service
public interface SeatService {

    List<SeatDTO> findAllSeats();
    SeatDTO findSeatById(Long id);
//    List<Seat> findByUserName(String userName);
//    List<Seat> findByReserved(boolean reserved);
    Optional<Seat> seatReservation(Long id, SeatReservationDTO seatReservationDTO);
//    boolean reserveSeat(Long seatId, Long userId);
//    boolean cancelReservation(Long reservationId);

}
