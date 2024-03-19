package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer eventId;
    private String name;
    private  String description;
    private LocalDateTime startedDateTime;
    private  LocalDateTime endedDateTime;

    @OneToMany
    @JoinColumn(name="scheduleId")
    private List<Session> schedule;

    @ManyToMany
    @JoinTable(
            name="Event_Member",
            joinColumns=@JoinColumn(name="event_id"),
            inverseJoinColumns =@JoinColumn(name="member_id")
    )
    Collection<Member> members=new ArrayList<>();

    public Event(){}
}
