package com.s1511.ticketcine.application.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.s1511.ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.ticketcine.application.mapper.MovieMapper;
import com.s1511.ticketcine.domain.repository.FunctionDetailsRepository;
import com.s1511.ticketcine.domain.repository.MovieRepository;
import com.s1511.ticketcine.domain.services.FunctionDetailsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FunctionDetailsServiceImpl implements FunctionDetailsService {

    private final FunctionDetailsRepository fdRepository;
    private final MovieMapper mp;
    private final MovieRepository mr;

    @Override
    public ReadDtoMovie getMovieById(String idMovie) {
        return mp.movieToReadDto(mr.findByIdAndActive(idMovie,true).orElse(null));
    }
    
}
