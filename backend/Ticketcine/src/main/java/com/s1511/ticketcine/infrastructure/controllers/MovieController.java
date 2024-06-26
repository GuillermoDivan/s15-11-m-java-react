package com.s1511.ticketcine.infrastructure.controllers;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s1511.ticketcine.application.implementations.MovieServiceImpl;
import com.s1511.ticketcine.domain.entities.Movie;
import com.s1511.ticketcine.domain.services.MovieService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/list")
    public ResponseEntity<?> activeMovieList(){
        return ResponseEntity.ok(movieService.getActiveMovieList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable @NotNull String id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }
    @GetMapping("/byTitle/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable @NotNull String title){
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }
    @GetMapping("/byReleaseDate/{releaseDate}")
    public ResponseEntity<?> findByReleaseDate(@PathVariable @NotNull LocalDate releaseDate){
        return ResponseEntity.ok(movieService.findByReleaseDate(releaseDate));
    }
    @GetMapping("/byAge/{agePlus18}")
    public ResponseEntity<?> getMovieByAge(@PathVariable @NotNull Boolean agePlus18){
        return ResponseEntity.ok(movieService.getMovieByAge(agePlus18));
    }
    @GetMapping("/byThreeD/{threeD}")
    public ResponseEntity<?> getMovieByThreeD(@PathVariable @NotNull Boolean threeD){
        return ResponseEntity.ok(movieService.getMovieByThreeD(threeD));
    }
    /*@GetMapping("/byGendre/{gendre}")
    public ResponseEntity<?> getMovieByGenre(@PathVariable @NotNull String genre){
        return ResponseEntity.ok(movieService.getMovieByGenre(genre));
    }*/
    @GetMapping("/bySubtitle/{subtitle}")
    public ResponseEntity<?> filterMoviesByLenguage(@PathVariable @NotNull Boolean subtitle){
        return ResponseEntity.ok(movieService.findBySubtitleAndActive(subtitle));
    }

    @GetMapping("/avgrate/{movieId}")
    public ResponseEntity<?> getAvgRateMovieId(@PathVariable @NotNull String movieId){
        return ResponseEntity.ok(movieService.findAvgRateByMovieId(movieId));
    }
}
