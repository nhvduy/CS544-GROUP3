package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.MemberService;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MemberControllerTest {

    private MemberService memberService;
    private MemberController memberController;

    @BeforeEach
    void setUp() {
        memberService = mock(MemberService.class);
        memberController = new MemberController(memberService);
    }

    @Test
    void testCalculateAttendance() {
        // Mock data
        Integer memberId = 1;
        MemberPayload memberPayload = new MemberPayload();
        memberPayload.setMemberId(memberId);

        List<AttendancePayload> attendanceList = new ArrayList<>();
        // Add some attendance payloads to the list

        // Mock service method
        when(memberService.calculateAttendanceForMember(memberId)).thenReturn(Map.of(memberPayload, attendanceList));

        // Call the controller method
        ResponseEntity<Map<MemberPayload, List<AttendancePayload>>> responseEntity = memberController.calculateAttendance(memberId);

        // Verify the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Map<MemberPayload, List<AttendancePayload>> responseBody = responseEntity.getBody();
        assertEquals(1, responseBody.size()); // Assuming only one member in the response
        // You can add more assertions based on the expected behavior of your controller
    }
}