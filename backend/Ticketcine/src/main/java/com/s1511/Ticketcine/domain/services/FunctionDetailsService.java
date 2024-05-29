package com.s1511.Ticketcine.domain.services;

import org.springframework.http.ResponseEntity;

import com.s1511.Ticketcine.application.dto.movie.ReadDtoMovie;

public interface FunctionDetailsService {

    ReadDtoMovie getMovieById(String idMovie);



}
