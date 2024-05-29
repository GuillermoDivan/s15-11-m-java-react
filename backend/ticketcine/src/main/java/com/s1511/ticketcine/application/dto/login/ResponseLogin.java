package com.s1511.ticketcine.application.dto.login;

public record ResponseLogin(
        String jwt,
        String role,
        String id,
        String firstName,
        String lastName
) {
}