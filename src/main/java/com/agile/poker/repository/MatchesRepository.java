package com.agile.poker.repository;

import com.agile.poker.entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MatchesRepository extends JpaRepository<Matches, UUID> {
    /*
    @Query("SELECT m.playersId FROM matches m INNER JOIN players p WHERE m.id=:p.id")
    UUID findPlayerById(UUID id);

    @Query("SELECT p.isOwner FROM Players p WHERE p.id=:id")
    boolean isOwner(UUID id);
    */
}
