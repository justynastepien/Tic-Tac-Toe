package org.example.tictactoe.game;

import javax.persistence.*;
import lombok.*;
import org.example.tictactoe.common.BaseAuditableEntity;
import org.example.tictactoe.user.UserEntity;

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
    private int players = 0;

    @OneToMany(mappedBy = "game")
    private Set<UserEntity> userEntities;

    @Embedded
    private BaseAuditableEntity audit = new BaseAuditableEntity();

}
