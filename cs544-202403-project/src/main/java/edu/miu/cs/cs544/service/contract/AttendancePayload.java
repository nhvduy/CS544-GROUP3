package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Scanner;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendancePayload implements Serializable {
    private Integer scanRecordId;
    private MemberPayload member;
    private ScannerPayload scannerCode;
    private LocalDateTime scanDate;
//    private Integer accountId;
//    private String accountType;
//    private Integer balance;
//    private String description;
//    private String name;

}
