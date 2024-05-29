package com.s1511.ticketcine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.s1511.ticketcine.domain.entities.Movie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,String> {

    Optional<Movie> findByIdAndActive(String id, Boolean active);

    Optional<Movie> findByTitleAndActive(String title, Boolean active);

    List<Movie> findByReleaseDateAndActive(LocalDateTime time, Boolean active);

    //List<Movie> findByGenreAndActive(String genre, Boolean active);

    List<Movie> findByAdultAndActive(Boolean agePlus18, Boolean active);

    List<Movie> findByThreeDAndActive(Boolean threeD, Boolean active);

   List<Movie> findBySubtitleAndActive(Boolean subtitle, Boolean active);

    List<Movie> findByActive(Boolean active);


}
