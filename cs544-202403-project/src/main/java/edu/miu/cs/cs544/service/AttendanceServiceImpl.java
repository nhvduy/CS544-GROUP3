package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.constant.AccountType;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttendanceServiceImpl extends BaseReadWriteServiceImpl<AttendancePayload, Attendance,Integer> implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<AttendancePayload> getScanRecordByScannerCode(Integer scannerCode) {
        return null;
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
}
