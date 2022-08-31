package org.example.tictactoe.user;

import lombok.RequiredArgsConstructor;
import org.example.tictactoe.common.Constants;
import org.example.tictactoe.utilities.EmailValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EmailValidator emailValidator;

    ResponseEntity<UserEntity> register(UserEntity newUser) {
        Optional<UserEntity> entity = userRepository.findByUsername(newUser.getUsername());
        if(entity.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, Constants.USERNAME_TAKEN_MESSAGE);
        }
        entity = userRepository.findByEmail(newUser.getEmail());
        if(entity.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, Constants.EMAIL_TAKEN_MESSAGE);
        }
        if(!emailValidator.test(newUser.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_EMAIL_MESSAGE);
        }
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        UserEntity result = userRepository.save(newUser);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

}
