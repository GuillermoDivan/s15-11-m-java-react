package com.s1511.ticketcine.application.dto.screen;

import com.s1511.ticketcine.application.dto.seat.ResponseSeatDto;
import com.s1511.ticketcine.domain.entities.FunctionDetails;

import java.util.List;

public class ReadDtoScreen {
    private String id;
    private List<FunctionDetails> functionDetails; // TODO. CAMBIAR A DTO!!
    private List<ResponseSeatDto> seatsList;

}

// TODO. VER SI ES NECESARIO!!
