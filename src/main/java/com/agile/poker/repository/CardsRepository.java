package com.agile.poker.repository;

import com.agile.poker.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardsRepository extends JpaRepository<Cards, UUID> {

    @Query("SELECT c FROM Cards c WHERE deckId=:deckId")
    List<Cards> findByDeckId(UUID deckId);
}
