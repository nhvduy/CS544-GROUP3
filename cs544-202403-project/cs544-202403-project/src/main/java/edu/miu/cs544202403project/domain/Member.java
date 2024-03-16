package edu.miu.cs544202403project.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String firstName;
    private String lastName;

    private String email;

    private String barCode;

    @OneToMany
    Collection<Role> roles=new ArrayList<>();

    @ManyToMany
    Collection<Account> accounts=new ArrayList<>();

    @OneToMany
    Collection<ScanRecord> scanRecords=new ArrayList<>();
    @OneToMany
    Collection<EventRegister> eventRegisters =new ArrayList<>();

}
