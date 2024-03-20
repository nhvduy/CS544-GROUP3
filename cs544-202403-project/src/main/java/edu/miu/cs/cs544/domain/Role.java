package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleType;

    @ManyToMany(mappedBy = "roles")
    Collection<Account> defaultAccounts=new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="Member_Role",
            joinColumns=@JoinColumn(name="member_id"),
            inverseJoinColumns =@JoinColumn(name="role_id")
    )
    Collection<Member> members=new ArrayList<>();

    public Role(){}

}
