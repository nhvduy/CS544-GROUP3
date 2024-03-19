package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Scanner;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ScanRecordPayload implements Serializable {
    private Integer scanRecordId;
    private String barCode;
    private Scanner scannerCode;
    private LocalDateTime scanDateTime;

}
