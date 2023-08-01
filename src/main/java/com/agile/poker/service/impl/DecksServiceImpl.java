package com.agile.poker.service.impl;

import com.agile.poker.entity.Decks;
import com.agile.poker.repository.DecksRepository;
import com.agile.poker.service.DecksService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class DecksServiceImpl implements DecksService {

    @Autowired
    private DecksRepository deckRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Decks> findAll() {
        return deckRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Decks findById(UUID uuid) {
        return deckRepository.findById(uuid).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    @Transactional
    public Decks addDeck(Decks deck) {
        return deckRepository.save(deck);
    }

    @Override
    @Transactional
    public void deleteDeck(UUID uuid) {
        deckRepository.deleteById(uuid);
    }

    @Override
    @Transactional
    public Decks updateDeck(Decks existDeck, Decks deck) {

        existDeck.setTitle(deck.getTitle());
        existDeck.setDescription(deck.getDescription());
        return deckRepository.save(existDeck);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existByDeck(UUID uuid) {
        return deckRepository.existsById(uuid);
    }
}
