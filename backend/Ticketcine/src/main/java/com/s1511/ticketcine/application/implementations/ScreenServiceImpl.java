package com.s1511.ticketcine.application.implementations;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s1511.ticketcine.application.dto.screen.CreateDtoScreen;
import com.s1511.ticketcine.application.dto.screen.ReadDtoScreen;
import com.s1511.ticketcine.application.dto.screen.UpdateDtoScreen;
import com.s1511.ticketcine.application.mapper.ScreenMapper;
import com.s1511.ticketcine.application.mapper.SeatMapper;
import com.s1511.ticketcine.domain.entities.Screen;
import com.s1511.ticketcine.domain.repository.FunctionDetailsRepository;
import com.s1511.ticketcine.domain.repository.ScreenRepository;
import com.s1511.ticketcine.domain.repository.SeatRepository;
import com.s1511.ticketcine.domain.services.ScreenService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private ScreenRepository screenRepository;
    private ScreenMapper screenMapper;
    private SeatRepository seatRepository;
    private SeatMapper seatMapper;
    private FunctionDetailsRepository fdr;

    @Override //todo. ver si es necesario.
    public ReadDtoScreen createScreen(CreateDtoScreen createDtoScreen) {
        Screen screen = screenMapper.createDtoToScreen(createDtoScreen);
        Screen savedScreen = screenRepository.save(screen);
        return screenMapper.screenToReadDto(savedScreen);
    }
    @Override
    public ReadDtoScreen getScreenByIdAndActive(String id){
        Screen screen = screenRepository.findByIdAndActive(id,true).orElseThrow(() -> new RuntimeException("Screen not found"));
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

    @Override //todo. ver si es necesario. FACU DICE QUE SÍ PORQUE CAMBIA FUNCTION DETAILS!!!
    public ReadDtoScreen updateScreen(String id, UpdateDtoScreen updateDtoScreen) {
        Screen screen = screenRepository.findById(id).orElseThrow(() -> new RuntimeException("Screen not found"));
        screen.setName(updateDtoScreen.getName());
        //screen.setSeat(screenMapper.seatDTOToSeat(updateDtoScreen.getSeat()));
        screen.setActive(updateDtoScreen.getActive());
        Screen updatedScreen = screenRepository.save(screen);
        return screenMapper.screenToReadDto(updatedScreen);
    }

    @Override //todo. ver si es necesario.
    public void deleteScreen(String id) {
        if (!screenRepository.existsById(id)) {
            throw new RuntimeException("Screen not found");
        }
        screenRepository.deleteById(id);
    }

    @Override //TODO. PUEDE SERVIR PARA FILTRO 2D Y 3D.
    public List<ReadDtoScreen> selectTypeScreen(String idMovie, String typeScreen, String idCinema) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectTypeScreen'");
    }

    @Override // TODO.  DUPLICADO? VER CINEMASERVICE. CAPAZ ESTÁ EN USO.
    public List<ReadDtoScreen> selectMovieByCine(String idCinema) {
        List<Screen> screens = screenRepository.findByCinemaId(idCinema);

        return screenMapper.screenListToReadDtoList(screens);
    }

    @Override
    public List<ReadDtoScreen> selectScreenByCinemaIdAndMovieId(String cinemaId, String movieId) {
        
        List<Screen> screens = fdr.findByCinemaIdAndMovieName(cinemaId, movieId);
        return screenMapper.screenListToReadDtoList(screens);
    }

    
}

