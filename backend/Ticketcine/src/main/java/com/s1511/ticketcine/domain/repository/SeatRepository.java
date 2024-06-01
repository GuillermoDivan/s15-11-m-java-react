package com.s1511.ticketcine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.s1511.ticketcine.domain.entities.Seat;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
    @Query("SELECT s FROM Seat s WHERE s.currentUser.Id = ?1 AND s.availability IN ?2")
    List<Seat> findByCurrentUser_IdAndAvailability(String userId, List<Seat.Availability> availabilities);
    List<Seat> findByCinemaIdAndScreenId(String idCinema, String idScreen);
    List<Seat> findByScreenId(String idScreen);
    Optional<Seat> findBySeatNumberAndReserved(String seatNumber, Boolean reserved);


}
