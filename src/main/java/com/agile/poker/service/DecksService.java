package com.agile.poker.service;

import com.agile.poker.entity.Decks;

import java.util.List;
import java.util.UUID;

public interface DecksService {

    public List<Decks> findAll();
    public Decks findById(UUID uuid);
    public Decks addDeck(Decks decks);
    public void deleteDeck(UUID uuid);
    public Decks updateDeck(Decks existDeck, Decks deck);
    public boolean existByDeck(UUID uuid);
}
