package com.s1511.ticketcine.infrastructure.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.s1511.ticketcine.application.dto.comment.CreateDtoComment;
import com.s1511.ticketcine.application.dto.comment.ReadDtoComment;
import com.s1511.ticketcine.application.dto.comment.UpdateDtoComment;
import com.s1511.ticketcine.domain.services.CommentService;

import java.util.List;

@RequestMapping("/comment")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class CommentController {

    public final CommentService commentService;

    @Transactional
    @PostMapping("/create")
    public ResponseEntity<ReadDtoComment> createComment(
            @RequestBody @Valid @NotNull CreateDtoComment createComment){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.commentService.createComment(createComment));
    }

    @GetMapping("/id/{id}/{active}")
    public ResponseEntity<ReadDtoComment>  findCommentById(@PathVariable String id,
                                                     @PathVariable Boolean active){
        return ResponseEntity.ok(commentService.readCommentByCommentId(id, active));
    }

    @GetMapping("/allu/{userId}/{active}")
    public ResponseEntity<List<ReadDtoComment>> findAllCommentsByUserIdAndActive(
            @PathVariable String userId, @PathVariable Boolean active){
        return ResponseEntity.ok(commentService.readAllCommentByUserIdAndActive(userId, active));
    }

    @GetMapping("/allm/{movieId}/{active}")
    public ResponseEntity<List<ReadDtoComment>> findAllCommentsByMovieIdAndActive(
            @PathVariable String movieId, @PathVariable Boolean active){
        return ResponseEntity.ok(commentService.readAllCommentByMovieIdAndActive(movieId, active));
    }


    @Transactional
    @PutMapping("/update")
    public ResponseEntity<ReadDtoComment> updateComment(
            @RequestBody @Valid UpdateDtoComment updateComment){
        return ResponseEntity.ok(commentService.updateComment(updateComment));
    }

    @Transactional
    @DeleteMapping("/toggle/{id}/{userId}")
    public ResponseEntity<Boolean> toggleComment(@PathVariable String id, @PathVariable String userId){
        return ResponseEntity.ok(commentService.toggleComment(id, userId));
    }

}