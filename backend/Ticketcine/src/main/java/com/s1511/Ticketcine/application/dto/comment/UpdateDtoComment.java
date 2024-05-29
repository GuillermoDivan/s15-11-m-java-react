package com.s1511.Ticketcine.application.dto.comment;
import jakarta.validation.constraints.NotNull;

public record UpdateDtoComment(
        @NotNull(message = "El Id no puede ser nulo")
        String id,
        @NotNull(message = "El UserId no puede ser nulo")
        String userId,
        @NotNull(message = "El comentario no puede ser nulo")
        String comment
) {
}
