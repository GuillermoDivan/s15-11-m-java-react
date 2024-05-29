package com.s1511.Ticketcine.application.dto.screen;

import com.s1511.Ticketcine.application.dto.Seat.SeatDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateDtoScreen {
    @NotNull
    private String name;
    @NotNull
    private List<SeatDTO> seat;
    @NotNull
    private Boolean active;
}

