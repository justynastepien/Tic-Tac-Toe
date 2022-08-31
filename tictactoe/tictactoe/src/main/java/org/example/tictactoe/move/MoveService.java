package org.example.tictactoe.move;

import lombok.RequiredArgsConstructor;
import org.example.tictactoe.common.Constants;
import org.example.tictactoe.game.GameEntity;
import org.example.tictactoe.game.GameRepository;
import org.example.tictactoe.model.MoveRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoveService {

    private final GameRepository gameRepository;
    private final MoveRepository moveRepository;

    public void move(Long id, MoveRequest request) {
        validateRequest(id, request.getToken());
        moveRepository.save(MoveEntity.builder()
                .gameId(id)
                .playerId(request.getPlayerId())
                .col(request.getCol())
                .row(request.getRow())
                .made(LocalDateTime.now())
                .build()
        );
    }

    public Boolean turn(Long id, String token) {
        GameEntity game =  validateRequest(id, token);
        return game.isTurn();
    }

    public List<MoveEntity> getMoves(Long id) {
        return moveRepository.findAllWhereGameIdEquals(id);
    }

    private GameEntity validateRequest(Long id, String token) {
        GameEntity game =  gameRepository.findById(id).orElse(null);
        if(game == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.GAME_NOT_FOUND_MESSAGE);
        }
        if(!token.equals(game.getToken())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, Constants.INVALID_TOKEN_MESSAGE);
        }
        return game;
    }

}
