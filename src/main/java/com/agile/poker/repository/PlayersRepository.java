package com.agile.poker.repository;

import com.agile.poker.entity.Cards;
import com.agile.poker.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlayersRepository extends JpaRepository<Players, UUID> {

    @Query("SELECT p.isOwner FROM Players p WHERE p.id=:id")
    boolean isOwner(UUID id);

}
