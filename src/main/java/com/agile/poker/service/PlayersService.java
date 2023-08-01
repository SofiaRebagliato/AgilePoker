package com.agile.poker.service;

import com.agile.poker.entity.Players;

import java.util.List;
import java.util.UUID;

public interface PlayersService{

    public List<Players> getAllPlayers();
    public Players findById(UUID uuid);
    public Players addPlayer(Players player);
    public void deletePlayer(UUID uuid);
    public boolean isOwner(UUID uuid);
    public Players updatePlayer(Players playerExist, Players player);
    public boolean existPlayerById(UUID uuid);
}
