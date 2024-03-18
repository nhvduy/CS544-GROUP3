package edu.miu.cs.cs544.domain;

import edu.miu.cs.cs544.domain.constant.AccountType;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Scanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long scannerCode;

    @ManyToOne
    @JoinColumn(name = "locationId")
    edu.miu.cs.cs544.domain.Location location;

    @Enumerated(EnumType.STRING)
    AccountType accountType;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="eventId")//not working
//    Collection<Event> events=new ArrayList<>();
      @OneToOne
      @JoinColumn(name="eventId")
      Event event;
    public Scanner(){}
}
