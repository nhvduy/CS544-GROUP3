package edu.miu.cs544202403project.domain;

import edu.miu.cs544202403project.constant.AccountType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String name;
    private  String description;

    @Enumerated(EnumType.STRING)
    AccountType accountType;

}
