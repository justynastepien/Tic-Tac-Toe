package org.example.tictactoe.game;

import lombok.RequiredArgsConstructor;
import org.example.tictactoe.common.Constants;
import org.example.tictactoe.move.MoveRepository;
import org.example.tictactoe.user.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final MoveRepository moveRepository;

    ResponseEntity<List<GameEntity>> readAllGames(){
        return ResponseEntity.ok(gameRepository.findAll());
    }

    ResponseEntity<GameEntity> createNewGame(@RequestBody GameEntity newGame){
        newGame.setToken(generateToken());
        GameEntity result = gameRepository.save(newGame);
        return ResponseEntity.created(URI.create("/"  +result.getId()))
                .body(result);
    }

    public ResponseEntity<String> joinGame(Long id, UserEntity user) {
        Optional<GameEntity> entity = gameRepository.findById(id);
        if (entity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        GameEntity game = entity.get();
        List<UserEntity> players = game.getPlayers();
        players.add(user);
        game.setNumOfPlayers(game.getNumOfPlayers() + 1);
        gameRepository.save(game);
        if (game.getNumOfPlayers() == 2) {
            //TODO: start game
        }
        return ResponseEntity.ok(game.getToken());
    }

    public void endGame(Long id) {
        GameEntity game = gameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.GAME_NOT_FOUND_MESSAGE));
        moveRepository.deleteAll(moveRepository.findAllWhereGameIdEquals(game.getId()));
        gameRepository.deleteById(game.getId());
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }

}
