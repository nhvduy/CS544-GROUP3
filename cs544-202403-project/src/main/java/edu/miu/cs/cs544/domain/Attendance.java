package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
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

    private LocalDateTime scanDateTime;

    public Attendance(){}

}
