package com.s1511.ticketcine.application.dto.screen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.s1511.ticketcine.application.dto.seat.SeatDTO;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDtoScreen {
    private String id;
    private String name;
    private List<SeatDTO> seat;
    private Boolean active;
}
