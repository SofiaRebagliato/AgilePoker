package com.agile.poker.controller;

import com.agile.poker.entity.Participations;
import com.agile.poker.service.impl.ParticipationsServiceImpl;
import com.agile.poker.utils.Endpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(Endpoints.PARTICIPATIONS)
@RequiredArgsConstructor
public class ParticipationsController {

    private final ParticipationsServiceImpl participationsService;

    @GetMapping(Endpoints.GET_PARTICIPATIONS)
    public ResponseEntity<List<Participations>> getAllParticipations() {

        return new ResponseEntity<>(participationsService.findAll(), HttpStatus.OK);
    }

    @GetMapping(Endpoints.GET_BY_ID)
    public ResponseEntity<Participations> getPartById(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(participationsService.findById(id), HttpStatus.OK);
    }

    @PostMapping(Endpoints.SAVE)
    public ResponseEntity<Participations> createParticipation(@RequestBody Participations participations) {

        return new ResponseEntity<>(participationsService.saveParticipation(participations), HttpStatus.CREATED);
    }

    @PutMapping(Endpoints.EDIT)
    public ResponseEntity<Participations> updateParticipation(@PathVariable("id") UUID id, @RequestBody Participations participations) {
        var existParticipation = participationsService.findById(id);
        //Debería ser owner para que se pueda modificar
        if (participationsService.existByParticipation(id)) {
            participationsService.updateParticipation(existParticipation, participations);
            participationsService.saveParticipation(existParticipation);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            throw new IllegalArgumentException("Participation with id " + participations.getId() + "not found or the player isn't owner");
        }
    }

    @DeleteMapping(Endpoints.DELETE)
    public ResponseEntity<HttpStatus> deleteParticipation(@PathVariable("id") UUID id) {

//        if (player.isOwner()) {
            participationsService.deleteParticipation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            //throw new IllegalArgumentException("El jugador con id: " + participations.getPlayerId() + "no es owner y por tanto no tiene permisos para eliminar la participación");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
    }
}