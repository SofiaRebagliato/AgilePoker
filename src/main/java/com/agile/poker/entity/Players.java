package com.agile.poker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

@Table(name = "players")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "users_pk_id")
    @NotNull
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private UUID userId;

    /*
    @Column(name = "match_pk_id")
    @NotNull
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    private UUID matchId;
    */

    @Column(name = "is_owner")
    @NotNull
    private Boolean isOwner;

    @Column(name = "is_verify")
    @NotNull
    private Boolean isVerify;
}
