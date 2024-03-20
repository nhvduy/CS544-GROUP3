package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Scanner;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AttendancePayload implements Serializable {
    private Integer scanRecordId;
    private Member member;
    private Scanner scannerCode;
    private LocalDateTime scanDateTime;



}
