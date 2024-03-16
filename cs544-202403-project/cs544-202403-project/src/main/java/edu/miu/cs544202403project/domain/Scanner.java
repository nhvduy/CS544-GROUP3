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
    private long id;
    private String name;
    private String description;
    @ManyToOne
    Location location;
    @Enumerated(EnumType.STRING)
    AccountType accountType;

    @OneToMany
    Collection<Event> events=new ArrayList<>();
    @OneToMany
    Collection<ScanRecord> scanRecords=new ArrayList<>();
}
