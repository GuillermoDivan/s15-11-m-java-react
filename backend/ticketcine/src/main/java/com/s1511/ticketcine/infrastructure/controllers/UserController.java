package com.s1511.ticketcine.infrastructure.controllers;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.s1511.ticketcine.application.dto.user.CreateDtoUser;
import com.s1511.ticketcine.application.dto.user.ReadDtoUser;
import com.s1511.ticketcine.application.dto.user.UpdateDtoUser;
import com.s1511.ticketcine.domain.services.UserService;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

    public final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ReadDtoUser> registerUser(
            @RequestBody @Valid @NotNull CreateDtoUser createUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.userService.createUser(createUser));
    }

    @GetMapping("/id/{id}/{active}")
    public ResponseEntity<ReadDtoUser>  findUserById(@PathVariable String id,
                                                     @PathVariable Boolean active){
        return ResponseEntity.ok(userService.readUserById(id, active));
    }

    @GetMapping("/email/{email}/{active}")
    public ResponseEntity<ReadDtoUser>  findUserByEmail(@PathVariable String email,
                                                        @PathVariable Boolean active){
        return ResponseEntity.ok(userService.readUserByEmail(email, active));
    }

    @PutMapping("/update")
    public ResponseEntity<ReadDtoUser> updateUser(
            @RequestBody @Valid UpdateDtoUser updateUser){
        return ResponseEntity.ok(userService.updateUser(updateUser));
    }

    @PutMapping("/toggle/{id}")
    public ResponseEntity<Boolean> toggleUser(@PathVariable String id){
        return ResponseEntity.ok(userService.toggleUser(id));
    }

}
