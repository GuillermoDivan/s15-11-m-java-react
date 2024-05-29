package com.s1511.ticketcine.infrastructure.controllers;

import com.s1511.ticketcine.domain.services.CinemaService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping("/getCinemasCityName")
    private ResponseEntity<?> getCinemasCityName(){
        return ResponseEntity.ok(cinemaService.getCinemasCityName());
    }

    @GetMapping("/getCinemaListByCity/{city}")
    private ResponseEntity<?> getCinemaListByCity(@PathVariable @NotNull String city){
        return ResponseEntity.ok(cinemaService.getCinemaListByCity(city));
    }
    @GetMapping("/getMoviesByCine/{cinema}")
    private ResponseEntity<?> getMoviesByCine(@PathVariable @NotNull String cinema){
        return ResponseEntity.ok(cinemaService.getMoviesByCinema(cinema));
    }

}
