package edu.miu.cs544202403project.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double accountBalance;

    @OneToMany
    Collection<Account> accounts=new ArrayList<>();


}
