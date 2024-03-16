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
    private long id;
    private String barCode;
    private LocalDateTime scanDateTime;

}
