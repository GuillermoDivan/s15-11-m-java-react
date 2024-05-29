package com.s1511.Ticketcine.domain.services;

import com.s1511.Ticketcine.application.dto.movie.CreateDtoMovie;
import com.s1511.Ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.Ticketcine.application.dto.movie.ReadMovieApiData;
import com.s1511.Ticketcine.domain.entities.Movie;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MovieService {

    ResponseEntity<?> saveLastestMovies();
    ReadDtoMovie getMovieById(String id);
    List<ReadDtoMovie> getActiveMovieList();
    ReadDtoMovie getMovieByTitle(String title);
    List<ReadDtoMovie> findByReleaseDate(LocalDateTime time);
   // List<ReadDtoMovie> getMovieByGenre(String gendre);
    List<ReadDtoMovie> getMovieByAge(Boolean agePlus18);
    List<ReadDtoMovie> getMovieByThreeD(Boolean threeD);
    List<String> assignGenre(List<Integer> genre);
    List<Movie> findBySubtitleAndActive(Boolean subtitle);
}
