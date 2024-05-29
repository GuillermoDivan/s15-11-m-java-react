package com.s1511.Ticketcine.application.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.s1511.Ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.Ticketcine.application.mapper.MovieMapper;
import com.s1511.Ticketcine.domain.repository.FunctionDetailsRepository;
import com.s1511.Ticketcine.domain.repository.MovieRepository;
import com.s1511.Ticketcine.domain.services.FunctionDetailsService;

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
