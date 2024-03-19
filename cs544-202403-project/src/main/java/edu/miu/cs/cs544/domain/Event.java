package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long eventId;
    private String name;
    private  String description;
    private LocalDateTime startedDateTime;
    private  LocalDateTime endedDateTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="event_id")
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
