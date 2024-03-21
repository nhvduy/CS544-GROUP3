package edu.miu.cs.cs544.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Data
@Entity

@Inheritance(strategy=InheritanceType.JOINED)
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(nullable = false)
    private String roleType;

    @ManyToMany(mappedBy = "roles")
    Collection<Account> defaultAccounts = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonBackReference // Use this annotation to mark the non-owning side of the relationship
    private List<Member> members;
//    private Member member;

    public Role() {
    }

    public Role(String roleType) {
        this.roleType = roleType;
    }

    public Role(int roleId, String roleType) {
        this.roleId = roleId;
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleType='" + roleType + '\'' +
                ", defaultAccounts=" + defaultAccounts +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Collection<Account> getDefaultAccounts() {
        return defaultAccounts;
    }

    public void setDefaultAccounts(Collection<Account> defaultAccounts) {
        this.defaultAccounts = defaultAccounts;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
