package com.agile.poker.repository;

import com.agile.poker.entity.Cards;
import com.agile.poker.entity.Participations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParticipationsRepository extends JpaRepository<Participations, UUID> {
    /*
    @Query("SELECT part.cardId FROM Participations part WHERE cardId=:cardId")
    List<Cards> findValuesByCards (UUID cardId);
     */
}
