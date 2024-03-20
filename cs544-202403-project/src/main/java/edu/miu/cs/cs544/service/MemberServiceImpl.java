package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.constant.AccountType;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import edu.miu.cs.cs544.service.mapper.AttendanceToAttendancePayloadMapper;
import edu.miu.cs.cs544.service.mapper.MemberToMemberPayloadMapper;
import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Integer> implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberToMemberPayloadMapper memberMapper;
    private final AttendanceToAttendancePayloadMapper attendanceMapper;

    public MemberServiceImpl(MemberRepository memberRepository, MemberToMemberPayloadMapper memberMapper, AttendanceToAttendancePayloadMapper attendanceMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
        this.attendanceMapper = attendanceMapper;
    }

    @Override
    public Map<MemberPayload, List<AttendancePayload>> calculateAttendanceForMember(Integer memberId) {
        Member member = memberRepository.getReferenceById(memberId);
        List<AttendancePayload> attendancePayloads = member.getAttendances().stream().map(attendanceMapper::map).collect(Collectors.toList());
        Map<MemberPayload, List<AttendancePayload>> map = new HashMap<>();
        map.put(memberMapper.map(member), attendancePayloads);
        return map;
    }

//    private final MemberRepository memberRepository;
//    private final RoleRepository roleRepository;
//
//
//    @Override
//    public MemberRolesResponseDTO getRoles(long memberId) throws MemberNotFoundException {
//        final var member = memberRepository.findById(memberId).orElseThrow(
//                () -> new MemberNotFoundException(memberId)
//        );
//        return new MemberRolesResponseDTO(
//                memberId,
//                List.copyOf(member.getRole())
//        );
//    }
//
//    @Transactional
//    @Override
//    public ModifyMemberRoleResponseDTO assignRole(long roleId, long memberId) throws MemberNotFoundException, RoleNotFoundException {
//        final var member = memberRepository.findById(memberId).orElseThrow(
//                () -> new MemberNotFoundException(memberId)
//        );
//        final var role = roleRepository.findById(roleId).orElseThrow(() -> new RoleNotFoundException(roleId));
//        final var memberRoles = member.getRole();
//        final var memberAccounts = member.getAccounts();
//        final var supportedAccountTypes = memberAccounts.stream().map(Account::getType).collect(Collectors.toSet());
//        final var notYetSupportedAccountTypes = new HashSet<>(role.getDefaultAccountTypes());
//        notYetSupportedAccountTypes.removeAll(supportedAccountTypes);
//        memberRoles.add(role);
//        for (final var accountType : notYetSupportedAccountTypes) {
//            memberAccounts.add(
//                    new Account(
//                            "", "", accountType
//                    )
//            );
//        }
//        memberRepository.save(member);
//        return new ModifyMemberRoleResponseDTO(
//                memberId,
//                List.copyOf(member.getRole()),
//                List.copyOf(memberAccounts)
//        );
//    }
//
//    @Transactional
//    @Override
//    public ModifyMemberRoleResponseDTO removeRole(long roleId, long memberId) throws MemberNotFoundException, RoleNotFoundException {
//        final var member = memberRepository.findById(memberId).orElseThrow(
//                () -> new MemberNotFoundException(memberId)
//        );
//        final var role = roleRepository.findById(roleId).orElseThrow(
//                () -> new RoleNotFoundException(roleId)
//        );
//        member.getRole().remove(role);
//        memberRepository.save(member);
//        return new ModifyMemberRoleResponseDTO(
//                memberId,
//                List.copyOf(member.getRole()),
//                List.copyOf(member.getAccounts())
//        );
//    }

}
