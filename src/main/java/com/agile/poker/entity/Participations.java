package com.agile.poker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Table(name = "participations")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "player_pk_id")
    @NotNull
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private int playerId;

    @Column(name = "topic_pk_id")
    @NotNull
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private int topicId;

    @Column(name = "card_pk_id")
    @NotNull
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private int cardId;
}
