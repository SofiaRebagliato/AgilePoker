package com.agile.poker.service.impl;

import com.agile.poker.entity.Players;
import com.agile.poker.repository.PlayersRepository;
import com.agile.poker.service.PlayersService;
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
public class PlayersServiceImpl implements PlayersService {

    @Autowired
    private PlayersRepository playerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Players> getAllPlayers() {
        //isVerify = false;
        return playerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Players findById(UUID uuid) {
        return playerRepository.findById(uuid).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    @Transactional
    public Players addPlayer(Players player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(UUID uuid) {
        playerRepository.deleteById(uuid);
    }

    public boolean isOwner(UUID uuid) {
        if (playerRepository.isOwner(uuid)) {
            return true;
        }
        return false;
    }

    public Players updatePlayer(Players playerExist, Players player) {

        playerExist.setIsVerify(player.getIsVerify());
        playerExist.setIsOwner(player.getIsOwner()); //Se debería de permitir modificar el owner del player¿?
        return playerRepository.save(playerExist);
    }

    public boolean existPlayerById(UUID uuid) {
        return playerRepository.existsById(uuid);
    }
}
