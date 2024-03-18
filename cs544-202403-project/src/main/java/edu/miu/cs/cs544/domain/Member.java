package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;
    private  String firstName;
    private String lastName;

    private String email;

    private String barCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="member_id")
    Collection<Account> accounts=new ArrayList<>();

    @ManyToMany(mappedBy = "members")
    Collection<Role> roles=new ArrayList<>();


    @ManyToMany(mappedBy = "members")
    Collection<Event> events=new ArrayList<>();



    public Member(){}

}
