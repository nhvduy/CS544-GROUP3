package edu.miu.cs.cs544.domain;

import edu.miu.common.domain.AuditData;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;
    @Column(nullable = false, name = "First_Name")
    private  String firstName;
    @Column(nullable = false, name = "Last_Name")
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String barCode;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="member_Id")
    List<Account> accounts = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="Member_Role",
            joinColumns=@JoinColumn(name="member_Id"),
            inverseJoinColumns =@JoinColumn(name="role_Id")
    )
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(mappedBy = "members")
    Collection<Event> events=new ArrayList<>();

    @Embedded
    AuditData auditData = new AuditData();
}
