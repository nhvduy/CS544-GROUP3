package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl extends BaseReadWriteServiceImpl<AttendancePayload, Attendance,Integer> implements AttendanceService {

    @Autowired
    private AttendanceRepository scanRecordRepository;


    @Override
    public List<AttendancePayload> getScanRecordByScannerCode(Integer scannerCode) {
        return null;
    }
}
