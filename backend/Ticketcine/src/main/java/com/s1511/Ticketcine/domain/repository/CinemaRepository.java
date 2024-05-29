package com.s1511.Ticketcine.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.s1511.Ticketcine.domain.entities.Cinema;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository <Cinema, String>{
    Optional<Cinema> findByNameAndActive(String name, Boolean active);
    
}
