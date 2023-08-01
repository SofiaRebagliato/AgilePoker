package com.agile.poker.controller;

import com.agile.poker.entity.Cards;
import com.agile.poker.service.impl.CardsServiceImpl;
import com.agile.poker.utils.Endpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(Endpoints.CARDS)
@RequiredArgsConstructor
public class CardsController {

    @Autowired
    private CardsServiceImpl cardService;

    @GetMapping(Endpoints.GET_CARDS)
    public ResponseEntity<List<Cards>> getAllCards() {

        return new ResponseEntity<>(cardService.findAll(), HttpStatus.OK);
    }

    @GetMapping(Endpoints.GET_BY_ID)
    public ResponseEntity<Cards> getCardById(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(cardService.findById(id), HttpStatus.OK);
    }

    @PostMapping(Endpoints.SAVE)
    public ResponseEntity<Cards> addCards(@RequestBody Cards card) {

        return new ResponseEntity<>(cardService.addCard(card), HttpStatus.CREATED);
    }

    @PutMapping(Endpoints.EDIT)
    public ResponseEntity<Cards> updateCard(@PathVariable("id") UUID id, @RequestBody Cards card) {
        var existCards = cardService.findById(id);
        if (cardService.existByCard(id)) {
            cardService.updateCard(card, existCards);
            return new ResponseEntity<>(cardService.addCard(existCards), HttpStatus.ACCEPTED);
        } else {
            throw new IllegalArgumentException("Card with id " + card.getId() + "not found");
        }
    }

    @DeleteMapping(Endpoints.DELETE)
    public ResponseEntity<HttpStatus> deleteCard(@PathVariable("id") UUID id) {
            cardService.deleteCard(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(Endpoints.GET_CARDS_OF_DECK_ID)
    public ResponseEntity<List<Cards>> listCardsOfDeck(@PathVariable("id") UUID deckId) {
        return new ResponseEntity<>(cardService.listCardsOfDeck(deckId), HttpStatus.OK);
    }
}