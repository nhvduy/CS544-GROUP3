package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import org.springframework.stereotype.Service;

@Service
public class ScanRecordServiceImpl extends BaseReadWriteServiceImpl<ScanRecordPayload, ScanRecord,Integer> implements ScanRecordService{
}
