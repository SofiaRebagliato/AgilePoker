package com.agile.poker.service.impl;

import com.agile.poker.entity.Matches;
import com.agile.poker.repository.MatchesRepository;
import com.agile.poker.repository.PlayersRepository;
import com.agile.poker.service.MatchesService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class MatchesServiceImpl implements MatchesService {

    @Autowired
    private MatchesRepository matchesRepository;
    @Autowired
    private PlayersRepository playersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Matches> findAll() {
        return matchesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Matches findById(UUID uuid) {
        return matchesRepository.findById(uuid).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    @Transactional
    public Matches addMatch(Matches match) {
        return matchesRepository.save(match);
    }

    @Override
    @Transactional
    public void deleteMatch(UUID uuid) {
        //Solo se debería de poder eliminar si el player isOwner
        if (playersRepository.isOwner(uuid)) {
            matchesRepository.deleteById(uuid);
        }
    }

    @Override
    @Transactional
    public Matches updateMatch(Matches existMatch, Matches match) {
        //Solo se debería de poder modificar si el player isOwner
        if (playersRepository.isOwner(existMatch.getId())) {
            existMatch.setTitle(match.getTitle());
            existMatch.setDescription(match.getDescription());
        }
        return matchesRepository.save(existMatch);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existByMatch(UUID uuid) {
        return matchesRepository.existsById(uuid);
    }
}
