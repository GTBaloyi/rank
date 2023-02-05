package com.casino.rank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("casino")
public class CasinoController {


    @RequestMapping(value = "player/{playerId}/balance",method = RequestMethod.GET)
    public ResponseEntity getBalance(@PathVariable int playerId) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
