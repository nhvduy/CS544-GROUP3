package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Attendance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer attendanceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="scannerCode")//need to confirm
    private Scanner scanner;

    @ManyToOne
    @JoinColumn(name="member_Id")
    private Member member;

//    @ManyToOne
//    @JoinColumn(name="session_Id")
//    private Session session;
//
//    @ManyToOne
//    @JoinColumn(name="event_Id")
//    private Event event;



    private LocalDateTime scanDate;



}
