package org.example.tictactoe.game;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository repository;

    ResponseEntity<List<GameEntity>> readAllGames(){
        return ResponseEntity.ok(repository.findAll());
    }

    ResponseEntity<GameEntity> createNewGame(@RequestBody GameEntity newGame){
        GameEntity result = repository.save(newGame);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }

}
