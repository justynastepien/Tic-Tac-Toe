package org.example.tictactoe.controller;

import org.example.tictactoe.model.User;
import org.example.tictactoe.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping(value="/users")
    ResponseEntity<List<User>> readAllUsers(){
        return ResponseEntity.ok(service.readAllUsers());
    }

    @PostMapping(value="/users")
    ResponseEntity<User> createUser(@RequestBody @Valid User toCreate){
        User result = service.createUser(toCreate);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }

    @DeleteMapping(value="/users/{id}")
    ResponseEntity<?> deleteTask(@PathVariable int id){

        boolean result = service.deleteUser(id);

        if(result){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
