package org.example.tictactoe.controller;

import org.example.tictactoe.model.Game;
import org.example.tictactoe.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class GameController {

    private final GameService service;

    public GameController(GameService service){
        this.service = service;
    }

    @GetMapping(value="/games")
    ResponseEntity<List<Game>> readAllGames(){
        return ResponseEntity.ok(service.readAllGames());
    }

    @PostMapping(value="/games")
    ResponseEntity<Game> createGame(@RequestBody @Valid Game toCreate){
        Game result = service.createGame(toCreate);

        URI.create("/"+result.getId());
        return ResponseEntity.created(URI.create("http://localhost:8080/games/" + result.getToken())).body(result);
    }

    @DeleteMapping(value="/games/{id}")
    ResponseEntity<?> deleteGame(@PathVariable int id){

        boolean result = service.deleteGame(id);

        if(result){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping(value="/games/{token}/{playerid}/{move}")
    //@GetMapping(value="/games/{token}")
    ResponseEntity<List<Game>> readGames(){
        //TODO
        return null;
    }



}
