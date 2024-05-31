package com.s1511.ticketcine.application.dto.screen;
import jakarta.validation.constraints.NotNull;


public class CreateDtoScreen {
    @NotNull
    private String name;
    @NotNull
    private Boolean active;
}

// TODO. VER SI ES NECESARIO!!
