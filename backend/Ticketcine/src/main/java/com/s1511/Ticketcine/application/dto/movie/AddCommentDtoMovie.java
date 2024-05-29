package com.s1511.Ticketcine.application.dto.movie;

import com.s1511.Ticketcine.domain.entities.Comment;
import jakarta.validation.constraints.NotNull;

public record AddCommentDtoMovie(
        @NotNull
        String movieId,
        @NotNull
        String comment
) {
}
