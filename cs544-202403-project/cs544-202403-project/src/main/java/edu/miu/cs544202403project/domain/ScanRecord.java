package edu.miu.cs544202403project.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
@Data
@Entity
public class ScanRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long scanRecordId;
    private String barCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="scannerCode")
    private Scanner scannerCode;
    private LocalDateTime scanDateTime;

    public ScanRecord(){}

}
