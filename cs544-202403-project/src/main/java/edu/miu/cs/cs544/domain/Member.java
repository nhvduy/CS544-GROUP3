package edu.miu.cs.cs544.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.common.domain.AuditData;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Data
@Entity
//@NoArgsConstructor
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


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="member_id")
    Collection<Account> accounts=new ArrayList<>();

//    @ManyToMany(fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Attendance> attendances = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name="member_role",
            joinColumns=@JoinColumn(name="member_id"),
            inverseJoinColumns =@JoinColumn(name="role_id")
    )
//    @JsonIgnore
    @JsonIgnoreProperties("members") // Ignore 'members' property during serialization
    @JsonManagedReference // Use this annotation to mark the owning side of the relationship
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    Collection<Event> events=new ArrayList<>();

    public Member(){}

    @Embedded
    AuditData auditData = new AuditData();

}
