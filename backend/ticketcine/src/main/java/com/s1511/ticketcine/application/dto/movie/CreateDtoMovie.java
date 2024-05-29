package com.s1511.ticketcine.application.dto.movie;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CreateDtoMovie(
        boolean adult,
        String backdrop_path,
        List<Integer> genre_ids,
        int id,
        String original_language,
        String original_title,
        String overview,
        double popularity,
        String poster_path,
        String release_date,
        String title,
        boolean video,
        double vote_average,
        int vote_count
) {
}
