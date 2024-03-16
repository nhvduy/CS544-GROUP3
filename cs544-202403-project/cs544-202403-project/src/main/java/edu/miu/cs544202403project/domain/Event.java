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
    private  long id;

    private String name;
    private  String description;
    private LocalDateTime startedDateTime;

    private  LocalDateTime endedDateTime;

    @ManyToOne
    Schedule schedule;
    @OneToMany
    Collection<EventRegister> eventRegisters= new ArrayList<>();
    public Event(){}
}
