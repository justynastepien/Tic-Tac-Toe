package org.example.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MoveRequest {

    private String token;

    // czy to jest wgl potrzebne?
    // private Long playerId;

    private Mark mark;

    private Integer row;

    private Integer col;

}
