package com.agile.poker.service;

import com.agile.poker.entity.Participations;

import java.util.List;
import java.util.UUID;

public interface ParticipationsService {

    public List<Participations> findAll();
    public Participations findById(UUID uuid);
    public Participations saveParticipation(Participations participation);
    public void deleteParticipation(UUID uuid);
    public Participations updateParticipation(Participations existParticipation, Participations participation);
    public boolean existByParticipation(UUID uuid);
}
