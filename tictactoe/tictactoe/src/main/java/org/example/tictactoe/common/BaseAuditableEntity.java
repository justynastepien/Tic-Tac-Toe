package org.example.tictactoe.common;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable
@Getter
public
class BaseAuditableEntity {

    @Column(name = "CREATED")
    private LocalDateTime createdOn;

    @Column(name = "LAST_UPDATED")
    private LocalDateTime updatedOn;

    @PrePersist
    void prePersist(){
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate(){
        updatedOn = LocalDateTime.now();
    }

}
