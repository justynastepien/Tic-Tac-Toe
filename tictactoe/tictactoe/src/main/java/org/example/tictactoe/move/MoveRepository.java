package org.example.tictactoe.move;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoveRepository extends JpaRepository<MoveEntity, Long> {

    List<MoveEntity> findAllWhereGameIdEquals(Long gameId);

}
