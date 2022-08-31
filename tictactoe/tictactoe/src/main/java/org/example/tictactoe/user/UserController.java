package org.example.tictactoe.user;

import lombok.RequiredArgsConstructor;
import org.example.tictactoe.common.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = Constants.API_PREFIX + "/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    ResponseEntity<List<UserEntity>> readAllUsers(){
        return userService.readAllUsers();
    }

    @PostMapping
    ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        return userService.createUser(user);
    }

}
