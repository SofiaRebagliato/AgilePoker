package com.agile.poker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Table(name = "cards")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "value")
    @NotNull
    private int value;

    @Column(name = "decks_pk_id")
    @NotNull
    @JoinColumn(name = "decks_id", referencedColumnName = "id")
    private UUID deckId;
}
