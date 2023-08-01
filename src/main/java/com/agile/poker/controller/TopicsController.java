package com.agile.poker.controller;

import com.agile.poker.entity.Topics;
import com.agile.poker.service.impl.TopicsServiceImpl;
import com.agile.poker.utils.Endpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(Endpoints.TOPICS)
@RequiredArgsConstructor
public class TopicsController {

    private final TopicsServiceImpl topicsService;

    @GetMapping(Endpoints.GET_TOPICS)
    public ResponseEntity<List<Topics>> getAllTopics() {

        return new ResponseEntity<>(topicsService.findAll(), HttpStatus.OK);
    }

    @GetMapping(Endpoints.GET_BY_ID)
    public ResponseEntity<Topics> getTopicById(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(topicsService.findById(id), HttpStatus.OK);
    }

    @PostMapping(Endpoints.SAVE)
    public ResponseEntity<Topics> addTopic(@RequestBody Topics topic) {

        return new ResponseEntity<>(topicsService.addTopic(topic), HttpStatus.CREATED);
    }

    @PutMapping(Endpoints.EDIT)
    public ResponseEntity<Topics> updateTopic(@PathVariable("id") UUID id, @RequestBody Topics topic) {
        var existTopics = topicsService.findById(id);
        //También debería ser el player Owner para que se pueda modificar
        if (topicsService.existByTopic(id)) {

            topicsService.updateTopic(topic, existTopics);
            topicsService.addTopic(existTopics);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            throw new IllegalArgumentException("Topic with id " + topic.getId() + "not found or the player isn't owner");
        }
    }

    @DeleteMapping(Endpoints.DELETE)
    public ResponseEntity<HttpStatus> deleteTopic(@PathVariable("id") UUID id) {
//
//        if (player.isOwner()) {
            topicsService.deleteTopic(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            //throw new IllegalArgumentException("El jugador con id: " + participations.getPlayerId() + "no es owner y por tanto no tiene permisos para eliminar la participación");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
   }
}