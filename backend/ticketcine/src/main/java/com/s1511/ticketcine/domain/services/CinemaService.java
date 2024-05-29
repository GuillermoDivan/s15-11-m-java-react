package com.s1511.ticketcine.domain.services;


import com.s1511.ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.ticketcine.domain.entities.Cinema;

import java.util.List;

public interface CinemaService {

List<String> getCinemasCityName();
List<Cinema> getCinemaListByCity(String city);
List<ReadDtoMovie> getMoviesByCinema(String cinemaId);

}
