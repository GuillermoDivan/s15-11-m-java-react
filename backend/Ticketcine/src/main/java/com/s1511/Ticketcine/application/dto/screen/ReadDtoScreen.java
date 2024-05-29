package com.s1511.Ticketcine.application.dto.screen;

import com.s1511.Ticketcine.application.dto.Seat.SeatDTO;

import java.util.List;

public class ReadDtoScreen {
    private String id;
    private String name;
    private List<SeatDTO> seat;
    private Boolean active;
}
