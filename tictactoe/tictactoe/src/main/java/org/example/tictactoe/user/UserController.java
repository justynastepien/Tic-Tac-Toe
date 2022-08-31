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

    @PostMapping
    ResponseEntity<UserEntity> register(@RequestBody UserEntity user){
        return userService.register(user);
    }

}
