package com.s1511.Ticketcine.infrastructure.controllers;

import com.s1511.Ticketcine.application.implementations.MovieServiceImpl;
import com.s1511.Ticketcine.domain.entities.Movie;
import com.s1511.Ticketcine.domain.services.MovieService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;
    private final MovieServiceImpl movieServiceImp;

    @GetMapping("/saveLastestMovies")
    public  ResponseEntity<?> saveLastestMovies(){
        return ResponseEntity.ok(movieServiceImp.saveLastestMovies());
    }


    //metodos fuera del guardar las movies en la base de datos

    @GetMapping("/list")
    public ResponseEntity<?> activeMovieList(){
        return ResponseEntity.ok(movieServiceImp.getActiveMovieList());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable @NotNull String id){
        return ResponseEntity.ok(movieServiceImp.getMovieById(id));
    }
    @GetMapping("/getByTitle/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable @NotNull String title){
        return ResponseEntity.ok(movieServiceImp.getMovieByTitle(title));
    }
    @GetMapping("/getByReleaseDate/{releaseDate}")
    public ResponseEntity<?> findByReleaseDate(@PathVariable @NotNull LocalDateTime releaseDate){
        return ResponseEntity.ok(movieServiceImp.findByReleaseDate(releaseDate));
    }
    @GetMapping("/getByAge/{agePlus18}")
    public ResponseEntity<?> getMovieByAge(@PathVariable @NotNull Boolean agePlus18){
        return ResponseEntity.ok(movieServiceImp.getMovieByAge(agePlus18));
    }
    @GetMapping("/getByThreeD/{threeD}")
    public ResponseEntity<?> getMovieByThreeD(@PathVariable @NotNull Boolean threeD){
        return ResponseEntity.ok(movieServiceImp.getMovieByThreeD(threeD));
    }
    /*@GetMapping("/getByGendre/{gendre}")
    public ResponseEntity<?> getMovieByGenre(@PathVariable @NotNull String genre){
        return ResponseEntity.ok(movieServiceImp.getMovieByGenre(genre));
    }*/
    @GetMapping("/getBySubtitle/{subtitle}")
    public ResponseEntity<?> filterMoviesByLenguage(@PathVariable @NotNull Boolean subtitle){
        return ResponseEntity.ok(movieServiceImp.findBySubtitleAndActive(subtitle));
    }
}
