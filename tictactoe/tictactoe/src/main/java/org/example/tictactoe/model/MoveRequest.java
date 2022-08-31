package org.example.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MoveRequest {

    private String token;

    private Long playerId;

    private Mark mark;

    private Integer row;

    private Integer col;

}
