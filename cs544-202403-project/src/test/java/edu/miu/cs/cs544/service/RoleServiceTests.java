package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.repository.RoleRepository;
import edu.miu.cs.cs544.service.contract.RolePayload;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTests {

    @TestConfiguration
    static class RoleServiceImplTestContextConfiguration{

        @Bean
        public RoleService roleService(){
            return new RoleServiceImpl();
        }
    }

    @Autowired
    private  RoleService roleService;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private MemberRepository memberRepository;

    @Before
    public void setUp() {
        Member member = new Member();
        member.setFirstName("Bob");
        member.setLastName("Smith");
        member.setEmail("bob@gmail.com");
        member.setBarCode("123");
        Set<Role> roleSet = new HashSet<>();
        Role role1 = new Role(1,"teacher");
        Role role2 = new Role(2,"student");
        List<Member> members = new ArrayList<>();
        members.add(member);
        role1.setMembers(members);
        role2.setMembers(members);
        roleSet.add(role1);
        roleSet.add(role2);
        member.setRoles(roleSet);
        roleRepository.saveAndFlush(role1);
        roleRepository.saveAndFlush(role2);
        memberRepository.saveAndFlush(member);


//        Optional<Role> roleOptional = Optional.of(role1);
//        Mockito.when(roleRepository.findById(1)).thenReturn(roleOptional);
//        Mockito.when(roleRepository.save(role2)).thenReturn(role2);
    }

    //add role
    @Test
    public void whenAddRoleThenRoleShouldBeFound(){
        RolePayload role3 = new RolePayload(3,"head master");
        roleService.addRole(1,role3);
        Role role4 = roleRepository.findByMemberIdAndRoleId(1,3);
        assert role4 != null;
        assertThat(role4.getRoleId(), equalTo(role3.getRoleId()));
    }
}
