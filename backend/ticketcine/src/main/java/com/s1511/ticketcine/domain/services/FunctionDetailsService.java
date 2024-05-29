package com.s1511.ticketcine.domain.services;

import org.springframework.http.ResponseEntity;

import com.s1511.ticketcine.application.dto.movie.ReadDtoMovie;

public interface FunctionDetailsService {

    ReadDtoMovie getMovieById(String idMovie);



}
