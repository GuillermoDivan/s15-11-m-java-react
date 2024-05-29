package com.s1511.Ticketcine.domain.services;

import com.s1511.Ticketcine.application.dto.Seat.SeatDTO;
import com.s1511.Ticketcine.application.dto.Seat.SeatReservationDTO;
import com.s1511.Ticketcine.domain.entities.Seat;
import org.springframework.stereotype.Service;

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
