package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import edu.miu.cs.cs544.service.mapper.AttendanceToAttendancePayloadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Integer> implements AccountService{
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    private AttendanceToAttendancePayloadMapper attendanceToAttendancePayloadMapper;
    @Override
    public List<String> findAccountsByBalanceCondition() {
        return null;
    }


    @Override
    public List<AttendancePayload> getAttendanceByAccountIdAndStartTimeAndEndTime(Integer accountId, LocalDate startTime, LocalDate endTime) {
        List<Attendance> attendanceList = accountRepository.findAllByAccountId(accountId, startTime.atTime(0, 0, 0), endTime.atTime(0,0,0));
        List<AttendancePayload> attendancePayloadList = attendanceList.stream().map(attendanceToAttendancePayloadMapper::map).toList();
        return attendancePayloadList;

    }
}
