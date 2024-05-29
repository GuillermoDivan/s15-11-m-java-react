package com.s1511.ticketcine.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s1511.ticketcine.application.dto.movie.ReadDtoMovie;
import com.s1511.ticketcine.domain.services.FunctionDetailsService;

@RestController
@RequestMapping("/functionDetails")
public class FunctionDetailsController {

    @Autowired
    private FunctionDetailsService fdService;



    //TRAE FUNCTIONDETAILS PARA MOVIE CON ID
    @GetMapping("getScreenByMovieId/{idMovie}")
    public ResponseEntity<ReadDtoMovie> getScreenByMovieId(@PathVariable String idMovie){
        ReadDtoMovie dto = fdService.getMovieById(idMovie);
        return ResponseEntity.ok(dto);
    }
    

}
