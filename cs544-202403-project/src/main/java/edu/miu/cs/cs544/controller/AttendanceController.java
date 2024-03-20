package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.AttendanceService;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scannerRecords")
public class AttendanceController extends BaseReadWriteController<AttendancePayload, Attendance,Integer> {
    private final AttendanceService attendanceService;
    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/{scannerCode}/records")
    public ResponseEntity<?> getScanRecordsByScannerCode(@PathVariable Integer scannerCode){
        //List<ScanRecordPayload> scanRecord=scanRecordService.
        return null;
    }
    @GetMapping("/members/{memberId}/attendance")
    public ResponseEntity<Map<Member, List<Attendance>>> calculateAttendance(@PathVariable Integer memberId) {
        Map<Member, List<Attendance>> attendanceMap = attendanceService.calculateAttendanceForMember(memberId);
        return ResponseEntity.ok(attendanceMap);
    }
}
