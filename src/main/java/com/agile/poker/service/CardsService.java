package com.agile.poker.service;

import com.agile.poker.entity.Cards;

import java.util.List;
import java.util.UUID;

public interface CardsService {

    public List<Cards> findAll();
    public Cards findById(UUID uuid);
    public Cards addCard(Cards card);
    public void deleteCard(UUID uuid);
    public Cards updateCard(Cards card, Cards existCard);
    public boolean existByCard(UUID uuid);
    public List<Cards> listCardsOfDeck(UUID deckId);
}
