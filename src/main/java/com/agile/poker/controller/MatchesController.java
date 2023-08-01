package com.agile.poker.controller;

import com.agile.poker.entity.Matches;
import com.agile.poker.service.impl.MatchesServiceImpl;
import com.agile.poker.utils.Endpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(Endpoints.MATCHES)
@RequiredArgsConstructor
public class MatchesController {

    @Autowired
    private MatchesServiceImpl matchesService;

    @GetMapping(Endpoints.GET_MATCHES)
    public ResponseEntity<List<Matches>> getAllMatches() {

        return new ResponseEntity<>(matchesService.findAll(), HttpStatus.OK);
    }

    @GetMapping(Endpoints.GET_BY_ID)
    public ResponseEntity<Matches> getMatchById(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(matchesService.findById(id), HttpStatus.OK);
    }

    @PostMapping(Endpoints.SAVE)
    public ResponseEntity<Matches> createMatch(@RequestBody Matches match) {

        return new ResponseEntity<>(matchesService.addMatch(match), HttpStatus.CREATED);
    }

    @PutMapping(Endpoints.EDIT)
    public ResponseEntity<Matches> updateMatch(@PathVariable("id") UUID id, @RequestBody Matches match) {
        var matchExist = matchesService.findById(id);
        if (matchesService.existByMatch(id)) {
        matchesService.updateMatch(matchExist, match);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            throw new IllegalArgumentException("Match with id " + match.getId() + "not found or the player isn't owner");
        }
    }

    @DeleteMapping(Endpoints.DELETE)
    public ResponseEntity<HttpStatus> deleteMatch(@PathVariable("id") UUID id) {

        matchesService.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
