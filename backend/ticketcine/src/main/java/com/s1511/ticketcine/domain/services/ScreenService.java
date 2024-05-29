package com.s1511.ticketcine.domain.services;
import java.util.List;

import com.s1511.ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.ticketcine.application.dto.screen.CreateDtoScreen;
import com.s1511.ticketcine.application.dto.screen.ReadDtoScreen;
import com.s1511.ticketcine.application.dto.screen.UpdateDtoScreen;
import com.s1511.ticketcine.application.dto.seat.SeatDTO;
import com.s1511.ticketcine.domain.entities.Screen;

public interface ScreenService {
    ReadDtoScreen createScreen(CreateDtoScreen createDtoScreen);
    ReadDtoScreen getScreenByIdAndName(String id, String name);
    List<ReadDtoScreen> getAllScreens();
    ReadDtoScreen updateScreen(String id, UpdateDtoScreen updateDtoScreen);
    void deleteScreen(String id);
/*     List<SeatDTO> selectTypeScreen(String idCinema, String typeScreen, String idScreen);
 */
    List<ReadDtoScreen> selectTypeScreen(String idMovie, String typeScreen, String idCinema);
    List<ReadDtoScreen> selectMovieByCine(String idCinema);
    List<ReadDtoScreen> selectScreenByCinemaIdAndMovieId(String cinemaId, String movieId);

}

