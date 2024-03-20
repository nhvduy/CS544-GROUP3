package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;

import java.util.List;

public interface ScanRecordService extends BaseReadWriteService<ScanRecordPayload, ScanRecord,Integer> {
    List<ScanRecordPayload> getScanRecordByScannerCode(Integer scannerCode);
}
