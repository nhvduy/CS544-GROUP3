package edu.miu.cs544202403project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sessionId;

    private LocalDateTime startedDateTime;

    private LocalDateTime endedDateTime;

    private Integer numOfSessions;

    public Session(){}
}
