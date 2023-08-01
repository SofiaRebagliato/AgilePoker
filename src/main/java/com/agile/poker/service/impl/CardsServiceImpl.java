package com.agile.poker.service.impl;

import com.agile.poker.entity.Cards;
import com.agile.poker.repository.CardsRepository;
import com.agile.poker.service.CardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CardsServiceImpl implements CardsService {

    private final CardsRepository cardsRepository;

    public List<Cards> findAll() {
        return cardsRepository.findAll();
    }

    public Cards findById(UUID uuid) {
        return cardsRepository.findById(uuid).orElseThrow(() -> new NoSuchElementException());
    }

    public Cards addCard(Cards card) {
        return cardsRepository.save(card);
    }

    public void deleteCard(UUID uuid) {
        cardsRepository.deleteById(uuid);
    }

    public Cards updateCard(Cards card, Cards existCard) {

        existCard.setTitle(card.getTitle());
        existCard.setValue(card.getValue());
        return cardsRepository.save(existCard);
    }

    public boolean existByCard(UUID uuid) {
        return cardsRepository.existsById(uuid);
    }

    public List<Cards> listCardsOfDeck(UUID deckId) {
        return cardsRepository.findByDeckId(deckId);
    }
}
