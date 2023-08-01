package com.agile.poker.service;

import com.agile.poker.entity.Matches;

import java.util.List;
import java.util.UUID;

public interface MatchesService {

    public List<Matches> findAll();
    public Matches findById(UUID uuid);
    public Matches addMatch(Matches match);
    public void deleteMatch(UUID uuid);
    public Matches updateMatch(Matches existMatch, Matches match);
    public boolean existByMatch(UUID uuid);
}
