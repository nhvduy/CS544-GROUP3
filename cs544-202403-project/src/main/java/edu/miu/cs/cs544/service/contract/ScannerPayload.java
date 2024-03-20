package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.constant.AccountType;
import lombok.Data;

import java.io.Serializable;

@Data
public class ScannerPayload implements Serializable {
    private Integer scannerCode;
    private Integer eventId;
    private String accountType;
}
