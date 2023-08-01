package com.agile.poker.service.impl;

import com.agile.poker.entity.Participations;
import com.agile.poker.repository.ParticipationsRepository;
import com.agile.poker.service.ParticipationsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ParticipationsServiceImpl implements ParticipationsService {

    private final ParticipationsRepository participationsRepository;

    public List<Participations> findAll() {
        return participationsRepository.findAll();
    }

    public Participations findById(UUID uuid) {
        return participationsRepository.findById(uuid).orElseThrow(() -> new NoSuchElementException());
    }

    public Participations saveParticipation(Participations participation) {
        return participationsRepository.save(participation);
    }

    public void deleteParticipation(UUID uuid) {
        participationsRepository.deleteById(uuid);
    }

    public void notOwner(UUID uuid) {
        participationsRepository.notify();
    }

    public Participations updateParticipation(Participations existParticipation, Participations participation) {
        //Solo se podrá modificar la participación si el jugador es owner
        existParticipation.setPlayerId(participation.getPlayerId());
        existParticipation.setTopicId(participation.getTopicId());
        existParticipation.setCardId(participation.getCardId());
        return participationsRepository.save(existParticipation);
    }

    public boolean existByParticipation(UUID uuid) {
        return participationsRepository.existsById(uuid);
    }

    /*
    public Double calculoMedia(int value){
    }
    */
}
