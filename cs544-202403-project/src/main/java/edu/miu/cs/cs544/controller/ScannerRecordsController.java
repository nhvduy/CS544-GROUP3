package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.ScanRecordService;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scannerRecords")
public class ScannerRecordsController extends BaseReadWriteController<ScanRecordPayload, ScanRecord,Integer> {

    @Autowired
    private  ScanRecordService scanRecordService;

    @GetMapping("/{scannerCode}/records")
    public ResponseEntity<?> getScanRecordsByScannerCode(@PathVariable Integer scannerCode){
        //List<ScanRecordPayload> scanRecord=scanRecordService.
        return null;
    }
}
