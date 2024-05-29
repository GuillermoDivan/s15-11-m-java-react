package com.s1511.Ticketcine.domain.services;
import com.s1511.Ticketcine.application.dto.Seat.SeatDTO;
import com.s1511.Ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.Ticketcine.application.dto.screen.CreateDtoScreen;
import com.s1511.Ticketcine.application.dto.screen.ReadDtoScreen;
import com.s1511.Ticketcine.application.dto.screen.UpdateDtoScreen;
import com.s1511.Ticketcine.domain.entities.Screen;

import java.util.List;

public interface ScreenService {
    ReadDtoScreen createScreen(CreateDtoScreen createDtoScreen);
    ReadDtoScreen getScreenByIdAndName(String id, String name);
    List<ReadDtoScreen> getAllScreens();
    ReadDtoScreen updateScreen(String id, UpdateDtoScreen updateDtoScreen);
    void deleteScreen(String id);
/*     List<SeatDTO> selectTypeScreen(String idCinema, String typeScreen, String idScreen);
 */
    List<ReadDtoScreen> selectTypeScreen(String idMovie, String typeScreen, String idCinema);
    List<Screen> selectMovieByCine(String idCinema);
    List<Screen> selectScreenByCinemaIdAndMovieId(String cinemaId, String movieId);

}

