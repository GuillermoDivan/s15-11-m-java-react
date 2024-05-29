package com.s1511.ticketcine.application.dto.movie;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record ReadMovieApiData(
        int page,
        List<CreateDtoMovie> results,
        int total_pages,
        int total_results
) {
}
