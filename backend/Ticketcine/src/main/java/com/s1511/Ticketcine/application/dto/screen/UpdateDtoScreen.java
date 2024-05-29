package com.s1511.Ticketcine.application.dto.screen;
import com.s1511.Ticketcine.application.dto.Seat.SeatDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDtoScreen {
    private String id;
    private String name;
    private List<SeatDTO> seat;
    private Boolean active;
}
