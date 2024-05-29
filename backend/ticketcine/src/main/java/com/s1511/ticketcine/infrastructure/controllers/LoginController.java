package com.s1511.ticketcine.infrastructure.controllers;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s1511.ticketcine.application.dto.login.RequestLogin;
import com.s1511.ticketcine.application.dto.login.ResponseLogin;
import com.s1511.ticketcine.domain.services.AuthenticationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
@SecurityRequirement(name = "Bearer Authentication")
public class LoginController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<ResponseLogin> login(
            @RequestBody @Valid @NotNull RequestLogin requestLogin){
        return ResponseEntity.status(HttpStatus.OK).body(
                this.authenticationService.login(requestLogin));
    }
}