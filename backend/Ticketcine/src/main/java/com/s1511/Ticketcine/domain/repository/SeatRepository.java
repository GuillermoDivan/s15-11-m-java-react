package com.s1511.Ticketcine.domain.repository;

import com.s1511.Ticketcine.domain.entities.Seat;
import com.s1511.Ticketcine.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByCinemaIdAndScreenId(String idCinema, String idScreen);
    List<Seat> findByScreenId(String idScreen);
    Optional<Seat> findBySeatNumberAndReserved(String seatNumber, Boolean reserved);


}
