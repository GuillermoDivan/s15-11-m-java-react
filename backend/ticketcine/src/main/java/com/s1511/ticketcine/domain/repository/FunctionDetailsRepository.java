package com.s1511.ticketcine.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.s1511.ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.ticketcine.domain.entities.FunctionDetails;
import com.s1511.ticketcine.domain.entities.Movie;
import com.s1511.ticketcine.domain.entities.Screen;

@Repository
public interface FunctionDetailsRepository extends JpaRepository<FunctionDetails, String> {

    Movie getMovieById(String idMovie);

    @Query("SELECT s FROM Screen s JOIN s.functionDetails fd WHERE s.cinema.id = :cinemaId AND fd.movieName = :movieName")
    List<Screen> findByCinemaIdAndMovieName(@Param("cinemaId") String cinemaId, @Param("movieName") String movieName);

    //List<Movie> findByCinemaAndActive(String cinema, boolean active);

    @Query("SELECT fd.movieName FROM FunctionDetails fd " +
            "JOIN fd.screen s " +
            "WHERE s.cinema.id = :cinemaId")
    List<String> findMovieNamesByCinemaId(@Param("cinemaId") String cinemaId);
}
