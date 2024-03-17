package edu.miu.cs544202403project.domain;

import edu.miu.cs544202403project.constant.AccountType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class Scanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long scannerCode;
    @ManyToOne
    Location location;
    @Enumerated(EnumType.STRING)
    AccountType accountType;
    @OneToMany
    @JoinColumn(name="eventId")
    Collection<Event> events=new ArrayList<>();
    public Scanner(){}
}
