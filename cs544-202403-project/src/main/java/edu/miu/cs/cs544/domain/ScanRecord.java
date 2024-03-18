package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
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
