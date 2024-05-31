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

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/saveLastestMovies")
    public  ResponseEntity<?> saveLastestMovies(){
        return ResponseEntity.ok(movieService.saveLastestMovies());
    }


    //metodos fuera del guardar las movies en la base de datos

    @GetMapping("/list")
    public ResponseEntity<?> activeMovieList(){
        return ResponseEntity.ok(movieService.getActiveMovieList());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable @NotNull String id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }
    @GetMapping("/getByTitle/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable @NotNull String title){
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }
    @GetMapping("/getByReleaseDate/{releaseDate}")
    public ResponseEntity<?> findByReleaseDate(@PathVariable @NotNull LocalDateTime releaseDate){
        return ResponseEntity.ok(movieService.findByReleaseDate(releaseDate));
    }
    @GetMapping("/getByAge/{agePlus18}")
    public ResponseEntity<?> getMovieByAge(@PathVariable @NotNull Boolean agePlus18){
        return ResponseEntity.ok(movieService.getMovieByAge(agePlus18));
    }
    @GetMapping("/getByThreeD/{threeD}")
    public ResponseEntity<?> getMovieByThreeD(@PathVariable @NotNull Boolean threeD){
        return ResponseEntity.ok(movieService.getMovieByThreeD(threeD));
    }
    /*@GetMapping("/getByGendre/{gendre}")
    public ResponseEntity<?> getMovieByGenre(@PathVariable @NotNull String genre){
        return ResponseEntity.ok(movieService.getMovieByGenre(genre));
    }*/
    @GetMapping("/getBySubtitle/{subtitle}")
    public ResponseEntity<?> filterMoviesByLenguage(@PathVariable @NotNull Boolean subtitle){
        return ResponseEntity.ok(movieService.findBySubtitleAndActive(subtitle));
    }

    @GetMapping("/avgrate/{movieId}")
    public ResponseEntity<?> getAvgRateMovieId(@PathVariable @NotNull String movieId){
        return ResponseEntity.ok(movieService.findAvgRateByMovieId(movieId));
    }
}
