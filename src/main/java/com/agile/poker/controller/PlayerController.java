package com.agile.poker.controller;

import com.agile.poker.entity.Players;
import com.agile.poker.service.impl.PlayersServiceImpl;
import com.agile.poker.utils.Endpoints;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(Endpoints.PLAYERS)
@RequiredArgsConstructor
@Slf4j
public class PlayerController {

    private final PlayersServiceImpl playerService;

    @GetMapping(Endpoints.GET_PLAYERS)
    public ResponseEntity<List<Players>> getAllPlayers() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping(Endpoints.GET_BY_ID)
    public ResponseEntity<Players> getPlayerById(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(playerService.findById(id), HttpStatus.OK);
    }

    @PostMapping(Endpoints.SAVE)
    public ResponseEntity<Players> addPlayer(@RequestBody Players player) {

        playerService.addPlayer(player);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(Endpoints.EDIT)
    public ResponseEntity<Players> updatePlayer(@PathVariable("id") UUID id, @RequestBody Players player) {
        var existPlayer = playerService.findById(id);

        if (playerService.isOwner(id)) {
            playerService.updatePlayer(existPlayer, player);
            playerService.addPlayer(player);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            throw new IllegalArgumentException("Player with id " + player.getId() + "not found");
        }
    }


    @DeleteMapping(Endpoints.DELETE)
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable("id") UUID id) {
        //Solo los Players que son Owners, son los que tienen permiso para hacer deletes
        if(playerService.isOwner(id)) {
            playerService.deletePlayer(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}