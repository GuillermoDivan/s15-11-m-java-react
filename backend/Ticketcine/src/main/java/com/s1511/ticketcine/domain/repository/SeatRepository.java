package com.s1511.ticketcine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.s1511.ticketcine.domain.entities.Seat;
import com.s1511.ticketcine.domain.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
  /*  List<Seat> findByFunctionDetails(String functionDetails);
    Optional<Seat> findBySeatNumberAndReserved(String seatNumber, Boolean reserved);

*/
}
