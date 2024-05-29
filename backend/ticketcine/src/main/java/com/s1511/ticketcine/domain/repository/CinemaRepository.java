package com.s1511.ticketcine.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.s1511.ticketcine.domain.entities.Cinema;

import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository <Cinema, String>{
    Optional<Cinema> findByNameAndActive(String name, Boolean active);
    
}
