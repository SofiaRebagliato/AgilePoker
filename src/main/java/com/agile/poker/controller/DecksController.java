package com.agile.poker.controller;

import com.agile.poker.entity.Decks;
import com.agile.poker.service.impl.DecksServiceImpl;
import com.agile.poker.utils.Endpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(Endpoints.DECKS)
@RequiredArgsConstructor
public class DecksController {

    private final DecksServiceImpl decksService;

    @GetMapping(Endpoints.GET_DECKS)
    public ResponseEntity<List<Decks>> getAllDecks() {

        return new ResponseEntity<>(decksService.findAll(), HttpStatus.OK); //Crear un listado de barajas que incluya
        // también en bbdd las cartas que tiene
    }

    @GetMapping(Endpoints.GET_BY_ID)
    public ResponseEntity<Decks> getDeckById(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(decksService.findById(id), HttpStatus.OK);
    }

    @PostMapping(Endpoints.SAVE)
    public ResponseEntity<Decks> addDecks(@RequestBody Decks deck) {

        return new ResponseEntity<>(decksService.addDeck(deck), HttpStatus.CREATED);
    }

    @PutMapping(Endpoints.EDIT)
    public ResponseEntity<Decks> updateDeck(@PathVariable("id") UUID id, @RequestBody Decks deck) {
        var existDeck = decksService.findById(id);
        if (decksService.existByDeck(id)) {
            decksService.updateDeck(existDeck, deck);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            throw new IllegalArgumentException("Deck with id " + deck.getId() + "not found");
        }
    }

    @DeleteMapping(Endpoints.DELETE)
    public ResponseEntity<HttpStatus> deleteDeck(@PathVariable("id") UUID id) {

            decksService.deleteDeck(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}