package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.domain.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends BaseRepository<Role, Integer>{

//    @Query("SELECT r FROM Role r JOIN r.members m WHERE r.roleId = :roleId AND m.memberId = :memberId")
    @Query("SELECT m.* FROM  Member m where m.memberId =:memberId join fetch m.roles")
    Role findByMemberIdAndRoleId(@Param("memberId") Integer memberId, @Param("roleId") Integer roleId);
}
