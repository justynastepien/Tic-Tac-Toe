package org.example.tictactoe.service;

import org.example.tictactoe.model.User;
import org.example.tictactoe.model.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> readAllUsers(){
        return repository.findAll();
    }

    public User createUser(User toCreate){

        User result = repository.save(toCreate);
        return result;
    }

    public boolean deleteUser(int id){

        repository.deleteById(id);

        return repository.existsById(id);
    }

}
