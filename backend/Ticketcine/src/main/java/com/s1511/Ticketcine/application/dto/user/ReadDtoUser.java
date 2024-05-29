package com.s1511.Ticketcine.application.dto.user;

public record ReadDtoUser(
        String id,
        String email,
        String firstName,
        String lastName,
        Long moviePoints
) {
}
