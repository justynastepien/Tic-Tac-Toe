package org.example.tictactoe.service;

import org.example.tictactoe.model.Game;
import org.example.tictactoe.model.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository){
        this.repository = repository;
    }

    public List<Game> readAllGames(){
        return repository.findAll();
    }

    public Game createGame(Game toCreate){

        toCreate.setToken(TokenGenerator.generateNewToken());

        Game result = repository.save(toCreate);
        return result;
    }

    public boolean deleteGame(int id){

        repository.deleteById(id);

        return repository.existsById(id);
    }
}
