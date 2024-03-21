package edu.miu.cs.cs544.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Session implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sessionId;

    @Column(
            nullable = false
    )
    private LocalDateTime startedDateTime;
    @Column(
            nullable = false
    )
    private LocalDateTime endedDateTime;

    private Integer numOfSessions;

    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="eventId")
    private Event event;

    public Session(LocalDateTime startedDateTime, LocalDateTime endedDateTime, int numOfSessions,String name) {
        this.startedDateTime = startedDateTime;
        this.endedDateTime = endedDateTime;
        this.numOfSessions = numOfSessions;
        this.name = name;
    }
}
