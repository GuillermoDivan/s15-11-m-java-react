package com.s1511.ticketcine.application.mapper;
import com.s1511.ticketcine.application.dto.seat.RequestSeatDto;
import org.mapstruct.Mapper;
import com.s1511.ticketcine.application.dto.screen.CreateDtoScreen;
import com.s1511.ticketcine.application.dto.screen.ReadDtoScreen;
import com.s1511.ticketcine.application.dto.screen.UpdateDtoScreen;
import com.s1511.ticketcine.domain.entities.Screen;
import com.s1511.ticketcine.domain.entities.Seat;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ScreenMapper {
        Screen createDtoToScreen (CreateDtoScreen createDtoScreen);
        ReadDtoScreen screenToReadDto (Screen screen);
        List<ReadDtoScreen> screenListToReadDtoList (List<Screen> ScreenList);

}

