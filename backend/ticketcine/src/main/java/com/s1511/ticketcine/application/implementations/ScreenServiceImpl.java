package com.s1511.ticketcine.application.implementations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s1511.ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.ticketcine.application.dto.screen.CreateDtoScreen;
import com.s1511.ticketcine.application.dto.screen.ReadDtoScreen;
import com.s1511.ticketcine.application.dto.screen.UpdateDtoScreen;
import com.s1511.ticketcine.application.dto.seat.SeatDTO;
import com.s1511.ticketcine.application.mapper.ScreenMapper;
import com.s1511.ticketcine.application.mapper.SeatMapper;
import com.s1511.ticketcine.domain.entities.Screen;
import com.s1511.ticketcine.domain.entities.Seat;
import com.s1511.ticketcine.domain.repository.FunctionDetailsRepository;
import com.s1511.ticketcine.domain.repository.ScreenRepository;
import com.s1511.ticketcine.domain.repository.SeatRepository;
import com.s1511.ticketcine.domain.services.ScreenService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreenServiceImpl implements ScreenService {
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private ScreenMapper screenMapper;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private FunctionDetailsRepository fdr;
    @Override
    public ReadDtoScreen createScreen(CreateDtoScreen createDtoScreen) {
        Screen screen = screenMapper.createDtoToScreen(createDtoScreen);
        Screen savedScreen = screenRepository.save(screen);
        return screenMapper.screenToReadDto(savedScreen);
    }
    @Override
    public ReadDtoScreen getScreenByIdAndName(String id, String name) {
        Screen screen = screenRepository.findByIdAndName(id,name).orElseThrow(() -> new RuntimeException("Screen not found"));
        if (!screen.getActive()) {
            throw new RuntimeException("Screen is inactive");
        }
        return screenMapper.screenToReadDto(screen);
    }

    @Override
    public List<ReadDtoScreen> getAllScreens() {
        List<Screen> screenList = screenRepository.findAll()
                .stream()
                .filter(Screen::getActive)
                .collect(Collectors.toList());

        return screenMapper.screenListToReadDtoList(screenList);
    }

    @Override
    public ReadDtoScreen updateScreen(String id, UpdateDtoScreen updateDtoScreen) {
        Screen screen = screenRepository.findById(id).orElseThrow(() -> new RuntimeException("Screen not found"));
        screen.setName(updateDtoScreen.getName());
        screen.setSeat(screenMapper.seatDTOToSeat(updateDtoScreen.getSeat()));
        screen.setActive(updateDtoScreen.getActive());
        Screen updatedScreen = screenRepository.save(screen);
        return screenMapper.screenToReadDto(updatedScreen);
    }

    @Override
    public void deleteScreen(String id) {
        if (!screenRepository.existsById(id)) {
            throw new RuntimeException("Screen not found");
        }
        screenRepository.deleteById(id);
    }
    @Override
    public List<ReadDtoScreen> selectTypeScreen(String idMovie, String typeScreen, String idCinema) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectTypeScreen'");
    }
    @Override
    public List<Screen> selectMovieByCine(String idCinema) {
        List<Screen> screens = screenRepository.findByCinemaId(idCinema);

        return screens;
    }
    @Override
    public List<Screen> selectScreenByCinemaIdAndMovieId(String cinemaId, String movieId) {
        
        List<Screen> screens = fdr.findByCinemaIdAndMovieName(cinemaId, movieId);
        return screens;
    }

    
}

