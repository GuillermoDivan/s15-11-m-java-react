package com.s1511.ticketcine.application.dto.movie;


import jakarta.validation.constraints.NotNull;

public record AddCommentDtoMovie(
        @NotNull
        String movieId,
        @NotNull
        String comment
) {
}
