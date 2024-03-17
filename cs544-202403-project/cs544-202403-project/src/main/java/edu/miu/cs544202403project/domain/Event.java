package edu.miu.cs544202403project.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long eventId;
    private String name;
    private  String description;
    private LocalDateTime startedDateTime;
    private  LocalDateTime endedDateTime;

    @OneToOne
    Schedule schedule;

    @ManyToMany
    @JoinTable(
            name="Event_Member",
            joinColumns=@JoinColumn(name="event_id"),
            inverseJoinColumns =@JoinColumn(name="member_id")
    )
    Collection<Member> members=new ArrayList<>();

    public Event(){}
}
