package edu.miu.cs.cs544.service;

import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;

@Service
public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Integer> implements MemberService {
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
