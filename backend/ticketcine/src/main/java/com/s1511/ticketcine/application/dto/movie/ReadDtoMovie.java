package com.s1511.ticketcine.application.dto.movie;
import java.time.LocalDate;
import java.util.List;



public record ReadDtoMovie(
        String id,
        String title,
        String cinema,
        String description,
        LocalDate releaseDate,
        List<String> comment,
        String rate,
        Boolean adult,
        String image,
        List<String> genre,
        Boolean threeD,
        Boolean subtitle
) {
}
