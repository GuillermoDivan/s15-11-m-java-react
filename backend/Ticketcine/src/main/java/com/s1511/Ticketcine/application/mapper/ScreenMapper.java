package com.s1511.Ticketcine.application.mapper;
import com.s1511.Ticketcine.application.dto.Seat.SeatDTO;
import com.s1511.Ticketcine.application.dto.screen.CreateDtoScreen;
import com.s1511.Ticketcine.application.dto.screen.DeleteDtoScreen;
import com.s1511.Ticketcine.application.dto.screen.ReadDtoScreen;
import com.s1511.Ticketcine.application.dto.screen.UpdateDtoScreen;
import com.s1511.Ticketcine.domain.entities.Screen;
import com.s1511.Ticketcine.domain.entities.Seat;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring")
public interface ScreenMapper {
        Screen createDtoToScreen (CreateDtoScreen createDtoScreen);
        ReadDtoScreen screenToReadDto (Screen screen);
        Screen updateDtoToScreen(UpdateDtoScreen updateDtoScreen);
        Screen deleteDtoToScreen(DeleteDtoScreen deleteDtoScreen);
        List<ReadDtoScreen> screenListToReadDtoList (List<Screen> ScreenList);
        List<Seat> seatDTOToSeat(List<SeatDTO> seat);
}

