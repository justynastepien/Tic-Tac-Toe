package org.example.tictactoe.controller;

import org.example.tictactoe.model.Game;
import org.example.tictactoe.model.GameRepository;
import org.example.tictactoe.model.User;
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
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }

    @DeleteMapping(value="/games/{id}")
    ResponseEntity<?> deleteGame(@PathVariable int id){

        boolean result = service.deleteGame(id);

        if(result){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

}
