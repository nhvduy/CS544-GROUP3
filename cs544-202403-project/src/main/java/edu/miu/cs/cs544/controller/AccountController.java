package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.service.AccountService;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/accounts")
public class AccountController extends BaseReadWriteController<AccountPayload, Account, Integer> {

    @Autowired
    AccountService accountService;

    @GetMapping("/{accountId}/attendace/{startTime}/{endTime}")
    public ResponseEntity<?> getAttendaceByAccountIdAndTime(@PathVariable Integer accountId, @PathVariable String startTime, @PathVariable String endTime) {

//        List<AttendancePayload> attendacePayloadList = accountService.getAttendanceByAccountIdAndStartTimeAndEndTime(accountId, startTime, endTime);
//        Map<Integer, List<AttendancePayload>> map = new HashMap<Integer, List<AttendancePayload>>();
//        map.put(accountId, attendacePayloadList);
//        return new ResponseEntity<>(map, HttpStatus.OK);
        return null;
    }
    

}
