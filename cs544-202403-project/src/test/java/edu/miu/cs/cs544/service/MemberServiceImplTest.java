package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.mapper.AttendanceToAttendancePayloadMapper;
import edu.miu.cs.cs544.service.mapper.MemberToMemberPayloadMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MemberServiceImplTest {
    private MemberRepository memberRepository;
    private MemberToMemberPayloadMapper memberMapper;
    private AttendanceToAttendancePayloadMapper attendanceMapper;
    private MemberServiceImpl memberService;

    @BeforeEach
    void setUp() {
        memberRepository = mock(MemberRepository.class);
        memberMapper = mock(MemberToMemberPayloadMapper.class);
        attendanceMapper = mock(AttendanceToAttendancePayloadMapper.class);
        memberService = new MemberServiceImpl(memberRepository, memberMapper, attendanceMapper);
    }

    @Test
    void testCalculateAttendanceForMember() {
        // Mock data
        Integer memberId = 1;
        Member member = new Member();
        member.setMemberId(memberId);

        List<Attendance> attendances = new ArrayList<>();
        // Add some attendances to the list

        List<AttendancePayload> attendancePayloads = new ArrayList<>();
        // Add some attendance payloads to the list

        // Mock repository method
        when(memberRepository.getReferenceById(memberId)).thenReturn(member);

        // Mock mapper methods
        when(attendanceMapper.map(any(Attendance.class))).thenReturn(new AttendancePayload());
        when(memberMapper.map(member)).thenReturn(new MemberPayload());

        // Call the service method
        Map<MemberPayload, List<AttendancePayload>> result = memberService.calculateAttendanceForMember(memberId);

        // Verify the result
        assertEquals(1, result.size()); // Assuming only one member in the map
        // You can add more assertions based on the expected behavior of your service method
    }

}