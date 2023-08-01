package com.agile.poker.repository;

import com.agile.poker.entity.Decks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DecksRepository extends JpaRepository<Decks, UUID> {
}
