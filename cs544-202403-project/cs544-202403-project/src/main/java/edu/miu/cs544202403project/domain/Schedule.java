package edu.miu.cs544202403project.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long scheduleId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="sessionList")
    Collection<Session> sessions=new ArrayList<>();


    public  Schedule(){}
}
