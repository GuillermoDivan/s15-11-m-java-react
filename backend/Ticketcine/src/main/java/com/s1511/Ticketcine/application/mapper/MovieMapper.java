package com.s1511.Ticketcine.application.mapper;

import com.s1511.Ticketcine.application.dto.movie.CreateDtoMovie;
import com.s1511.Ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.Ticketcine.domain.entities.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    Movie createDtoToMovie (CreateDtoMovie createDtoMovie);
    ReadDtoMovie movieToReadDto (Movie movie);
    List<ReadDtoMovie> movieListToReadDtoList (List<Movie> movieList);

}
