package edu.miu.cs.cs544.controller;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import io.restassured.RestAssured;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
@SpringBootTest
public class RoleControllerTest {

    Role role,role2;
    Member member;
    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/badge-system";
    }

    @Before
    public void addMemberAndRole(){
        Role role = new Role("student");
        Role role2 = new Role("teacher");
        Member member = new Member();
        member.setFirstName("Bob");
        member.setLastName("Smith");
        member.setEmail("bobsmith@gmail.com");
        member.setBarCode("124");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        roleSet.add(role2);
        member.setRoles(roleSet);

    }
    @Test
    public void testGetRole(){

    }

}