package org.example.tictactoe.game;

import javax.persistence.*;
import lombok.*;
import org.example.tictactoe.common.BaseAuditableEntity;
import org.example.tictactoe.move.MoveEntity;
import org.example.tictactoe.user.UserEntity;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "GAMES")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "CURR_NUM_PLAYERS")
    private int numOfPlayers = 0;

    @Column(name = "PLAYERS")
    @ElementCollection
    private List<UserEntity> players;

    @Column(name = "TURN")
    private boolean turn = false;

    @Embedded
    private BaseAuditableEntity audit = new BaseAuditableEntity();

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "GAME_ID", updatable = false, insertable = false)
    private List<MoveEntity> moves;

}
