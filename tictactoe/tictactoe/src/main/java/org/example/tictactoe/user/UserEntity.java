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
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Embedded
    private final BaseAuditableEntity audit = new BaseAuditableEntity();

}
