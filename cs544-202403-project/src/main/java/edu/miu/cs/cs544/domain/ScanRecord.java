package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
@Data
@Entity
public class ScanRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer scanRecordId;
    private String barCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="scannerCode")
    private Scanner scannerCode;
    private LocalDateTime scanDateTime;

    public ScanRecord(){}

}
