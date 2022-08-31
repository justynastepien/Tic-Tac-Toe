package org.example.tictactoe.move;

import lombok.*;
import org.example.tictactoe.model.Mark;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "MOVES")
public class MoveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "GAME_ID", nullable = false)
    private Long gameId;

    @Column(name = "PLAYER_ID", nullable = false)
    private Long playerId;

    @Column(name = "MARK")
    @Enumerated(EnumType.STRING)
    private Mark mark;

    @Column(name = "ROW")
    private int row;

    @Column(name = "COLUMN")
    private int col;

    @Column(name = "MADE", updatable = false)
    private LocalDateTime made;

}
