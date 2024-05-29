package com.s1511.ticketcine.application.dto.user;

public record ReadDtoUser(
        String id,
        String email,
        String firstName,
        String lastName,
        Long moviePoints
) {
}
