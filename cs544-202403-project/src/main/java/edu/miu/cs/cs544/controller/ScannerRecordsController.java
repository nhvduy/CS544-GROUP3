package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.service.AttendanceService;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scannerRecords")
public class ScannerRecordsController extends BaseReadWriteController<AttendancePayload, Attendance,Integer> {

    @Autowired
    private AttendanceService scanRecordService;

    @GetMapping("/{scannerCode}/records")
    public ResponseEntity<?> getScanRecordsByScannerCode(@PathVariable Integer scannerCode){
        //List<ScanRecordPayload> scanRecord=scanRecordService.
        return null;
    }
}
