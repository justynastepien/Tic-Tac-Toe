package org.example.tictactoe.user;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;
import org.example.tictactoe.common.BaseAuditableEntity;
import org.example.tictactoe.game.GameEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "Nick space must not be empty")
    @Column(name = "USERNAME")
    private String username;

    @NotBlank(message = "Mail space must not be empty")
    @Column(name = "EMAIL")
    private String email;

    @NotBlank(message = "Password space must not be empty")
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TOKEN")
    private String token;

    @Embedded
    private final BaseAuditableEntity audit = new BaseAuditableEntity();

    @ManyToOne()
    @JoinColumn(name="game_id")
    private GameEntity game;

}
