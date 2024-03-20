package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;

import java.util.List;

public interface AccountService extends BaseReadWriteService<AccountPayload, Account, Integer> {
    List<String> findAccountsByBalanceCondition();
    List<ScanRecordPayload> getAttendanceByAccountIdAndStartTimeAndEndTime(Long accountId, String startTime, String endTime);
}
