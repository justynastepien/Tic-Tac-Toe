package org.example.tictactoe.move;

import lombok.RequiredArgsConstructor;
import org.example.tictactoe.common.Constants;
import org.example.tictactoe.model.MoveRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = Constants.API_PREFIX + "/games/{id}")
public class MoveController {

    private final MoveService moveService;

    @GetMapping("/turn")
    Boolean turn(@PathVariable(name = "id") Long id, @RequestParam(name = "token") String token) {
        return moveService.turn(id, token);
    }

    @PostMapping("/moves")
    void move(@RequestBody MoveRequest request, @PathVariable(name = "id") Long id) {
        moveService.move(id, request);
    }

    @GetMapping("/moves")
    List<MoveEntity> getMoves(@PathVariable(name = "id") Long id) {
        return moveService.getMoves(id);
    }

}
