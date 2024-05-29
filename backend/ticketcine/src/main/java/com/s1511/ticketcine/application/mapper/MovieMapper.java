package com.s1511.ticketcine.application.mapper;

import org.mapstruct.Mapper;

import com.s1511.ticketcine.application.dto.movie.CreateDtoMovie;
import com.s1511.ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.ticketcine.domain.entities.Movie;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    Movie createDtoToMovie (CreateDtoMovie createDtoMovie);
    ReadDtoMovie movieToReadDto (Movie movie);
    List<ReadDtoMovie> movieListToReadDtoList (List<Movie> movieList);

}
