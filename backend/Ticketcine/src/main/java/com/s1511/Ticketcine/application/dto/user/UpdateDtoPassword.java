package com.s1511.Ticketcine.application.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateDtoPassword (
        @NotNull(message = "El Id no puede ser nulo")
        String id,
        @NotNull(message = "El Password no puede ser nulo")
        @Size(min = 7, message = "El Password debe tener al menos 8 carateres.")
        String password
){
}
