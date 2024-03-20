package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;

public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Integer>{
//    MemberRolesResponseDTO getRoles(long memberId) throws MemberNotFoundException;
//
//    ModifyMemberRoleResponseDTO assignRole(long roleId, long memberId) throws MemberNotFoundException, RoleNotFoundException;
//
//    ModifyMemberRoleResponseDTO removeRole(long roleId, long memberId) throws MemberNotFoundException, RoleNotFoundException;

}
