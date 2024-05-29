package com.s1511.Ticketcine.domain.repository;
import com.s1511.Ticketcine.domain.entities.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScreenRepository extends JpaRepository <Screen, String> {
    Optional<Screen> findByIdAndName (String id, String name); //TODO. Ver si sirve.
    Optional<Screen> findByIdAndActive (String id, Boolean active);
    List<Screen> findByCinemaId (String cinemaId);
}
