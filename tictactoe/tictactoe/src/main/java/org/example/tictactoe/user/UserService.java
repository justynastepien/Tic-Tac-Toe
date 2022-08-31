package org.example.tictactoe.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    ResponseEntity<List<UserEntity>> readAllUsers(){
        return ResponseEntity.ok(repository.findAll());
    }

    ResponseEntity<UserEntity> createUser(@RequestBody UserEntity newUser){
        UserEntity result = repository.save(newUser);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }

}
