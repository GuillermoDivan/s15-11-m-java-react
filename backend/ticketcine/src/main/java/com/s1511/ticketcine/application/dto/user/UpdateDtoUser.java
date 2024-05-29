package com.s1511.ticketcine.application.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateDtoUser(
        @NotNull(message = "El Id no puede ser nulo")
        String id,
        String firstName,
        String lastName
) {
}
