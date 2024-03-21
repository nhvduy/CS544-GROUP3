package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.domain.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void whenFindByMemberIdAndRoleId_thenReturnRole(){
        //given
        Member member = new Member();
        member.setFirstName("Bob");
        member.setLastName("Smith");
        member.setEmail("bob@gmail.com");
        member.setBarCode("123");
        Set<Role> roleSet = new HashSet<>();
        Role role1 = new Role("teacher");
        Role role2 = new Role("student");
        List<Member> members = new ArrayList<>();
        members.add(member);
        role1.setMembers(members);
        role2.setMembers(members);
        roleSet.add(role1);
        roleSet.add(role2);
        member.setRoles(roleSet);
        entityManager.persist(role1);
        entityManager.persist(role2);
        entityManager.persist(member);
        entityManager.flush();
        //when
        Role role3 = roleRepository.findByMemberIdAndRoleId(1,1);
        assertThat(role3.getRoleType(),equalTo("teacher"));
    }

}
