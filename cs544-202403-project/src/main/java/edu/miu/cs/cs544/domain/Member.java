package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;
    private  String firstName;
    private String lastName;

    private String email;

    private String barCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="member_id")
    Collection<Account> accounts=new ArrayList<>();

    @ManyToMany(mappedBy = "members",cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "member_role", // Name of the join table
//            joinColumns = @JoinColumn(name = "member_id"), // Name of the column for the member id
//            inverseJoinColumns = @JoinColumn(name = "role_id") // Name of the column for the role id
//    )
    Collection<Role> roles=new ArrayList<>();


    @ManyToMany(mappedBy = "members")
    Collection<Event> events=new ArrayList<>();

    @OneToMany
    @JoinColumn(name="member_id")//need to confirm
    List<Attendance> Attendance=new ArrayList<>();


    public Member(){}

}
