package com.s1511.ticketcine.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.s1511.ticketcine.domain.entities.Screen;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScreenRepository extends JpaRepository <Screen, String> {
    Optional<Screen> findByIdAndActive (String id, Boolean active);
    List<Screen> findByCinemaId (String cinemaId);
}