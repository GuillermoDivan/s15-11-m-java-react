package com.s1511.ticketcine.application.dto.screen;

import com.s1511.ticketcine.application.dto.seat.SeatDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import com.s1511.ticketcine.application.dto.seat.SeatDTO;

public class CreateDtoScreen {
    @NotNull
    private String name;
    @NotNull
    private List<SeatDTO> seat;
    @NotNull
    private Boolean active;
}

