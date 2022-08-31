package org.example.tictactoe.game;

import lombok.RequiredArgsConstructor;
import org.example.tictactoe.common.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = Constants.API_PREFIX + "/games")
public class GameController {

    private final GameService gameService;

    @GetMapping
    ResponseEntity<List<GameEntity>> readAllGames(){
        return gameService.readAllGames();
    }

    @PostMapping
    ResponseEntity<GameEntity> createNewGame(@RequestBody GameEntity newGame){
        return gameService.createNewGame(newGame);
    }

}
