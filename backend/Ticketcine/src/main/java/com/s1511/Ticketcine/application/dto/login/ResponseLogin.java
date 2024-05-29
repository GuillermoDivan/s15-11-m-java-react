package com.s1511.Ticketcine.application.dto.login;

public record ResponseLogin(
        String jwt,
        String role,
        String id,
        String firstName,
        String lastName
) {
}