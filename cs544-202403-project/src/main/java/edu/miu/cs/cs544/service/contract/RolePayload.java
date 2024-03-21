package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Member;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Data
public class RolePayload implements Serializable {

    private Integer roleId;
    private String roleType;

    Collection<Account> defaultAccounts=new ArrayList<>();

    Collection<Member> members=new ArrayList<>();

    public RolePayload() {
    }

    public RolePayload(String roleType) {
        this.roleType = roleType;
    }

    public RolePayload(int id, String roleType) {
        this.roleId = id;
        this.roleType = roleType;
    }

//    public RolePayload(Integer roleId, String roleType, Collection<Account> defaultAccounts, Collection<Member> members) {
    public RolePayload(Integer roleId, String roleType, Collection<Account> defaultAccounts) {
        this.roleId = roleId;
        this.roleType = roleType;
        this.defaultAccounts = defaultAccounts;
//        this.members = members;
    }
}
