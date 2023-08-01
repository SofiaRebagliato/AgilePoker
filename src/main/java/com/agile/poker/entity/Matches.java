package com.agile.poker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Table(name = "matches")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "decks_pk_id")
    @NotNull
    @JoinColumn(name = "decks_id", referencedColumnName = "id")
    private UUID deckId;

    @Column(name = "players_pk_id")
    @NotNull
    @JoinColumn(name = "players_id", referencedColumnName = "id")
    private UUID playerId;
}
