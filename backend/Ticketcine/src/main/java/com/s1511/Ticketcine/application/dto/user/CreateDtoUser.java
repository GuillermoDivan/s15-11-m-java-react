package com.s1511.Ticketcine.application.dto.user;
import jakarta.validation.constraints.*;

public record CreateDtoUser(
        @Email
        @NotNull(message = "El Email no puede ser nulo")
        String email,
        @NotNull(message = "El Password no puede ser nulo")
        @Size(min = 7, message = "El Password debe tener al menos 8 carateres.")
        String password,
        @NotNull(message = "El nombre no puede ser nulo")
        String firstName,
        @NotNull(message = "El apellido no puede ser nulo")
        String lastName
) {
}
