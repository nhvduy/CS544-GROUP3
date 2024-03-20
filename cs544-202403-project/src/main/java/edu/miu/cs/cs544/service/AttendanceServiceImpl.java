package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.constant.AccountType;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import edu.miu.cs.cs544.service.mapper.AttendanceToAttendancePayloadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttendanceServiceImpl extends BaseReadWriteServiceImpl<AttendancePayload, Attendance,Integer> implements AttendanceService {

    @Autowired
    private final AttendanceRepository attendanceRepository;

    @Autowired
    private AttendanceToAttendancePayloadMapper attendanceToAttendancePayloadMapper;
    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Map<Member, List<Attendance>> calculateAttendanceForMember(Integer memberId) {

        List<Attendance> attendanceList = attendanceRepository.findAttendanceByMemberId(memberId);
        Map<Member, List<Attendance>> attendanceMap = new HashMap<>();

        for (Attendance attendance : attendanceList) {

            Event event = attendance.getScanner().getEvent();

            Member member = event.getMembers().iterator().next();

            if (!attendanceMap.containsKey(member)) {
                attendanceMap.put(member, new ArrayList<>());
            }

            attendanceMap.get(member).add(attendance);
        }

        return attendanceMap;
    }

    @Override
    public List<AttendancePayload> getScanRecordByScannerCode(Integer scannerCode) {

//        List<Record> records = recordRepository.findByScannerId(scannerId);
//        return records.stream()
//                .map(record -> recordMapper.customMapping(record))
//                .collect(Collectors.toList());
//    }

        Optional<Attendance> scanRecords= attendanceRepository.findById(scannerCode);
        //return scanRecords.stream().map(attendance -> attanc)

        return null;
    }


}
