package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.constant.AccountType;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import edu.miu.cs.cs544.service.contract.MemberPayload;

import java.util.List;
import java.util.Map;

public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Integer>{
//    MemberRolesResponseDTO getRoles(long memberId) throws MemberNotFoundException;
//
//    ModifyMemberRoleResponseDTO assignRole(long roleId, long memberId) throws MemberNotFoundException, RoleNotFoundException;
//
//    ModifyMemberRoleResponseDTO removeRole(long roleId, long memberId) throws MemberNotFoundException, RoleNotFoundException;

    Map<MemberPayload, List<AttendancePayload>> calculateAttendanceForMember(Integer memberId);

    List<Member> getAllMembers();

}
