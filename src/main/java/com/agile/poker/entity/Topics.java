package com.agile.poker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Table(name = "topics")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_voting")
    @NotNull
    private Boolean isVoting;

    @Column(name = "match_pk_id")
    @NotNull
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    private UUID matchId;
}
