package edu.miu.cs.cs544.controller;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.repository.RoleRepository;
import edu.miu.cs.cs544.service.contract.RolePayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
@SpringBootTest
public class RoleControllerTest {

    Role role,role2;
    Member member;

    @MockBean
    MemberRepository memberRepository;

    @MockBean
    RoleRepository roleRepository;
    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/badge-system";
    }

    @Before
    public void addMemberAndRole(){
         role = new Role("student");
         role2 = new Role("teacher");
         member = new Member();
        member.setFirstName("Bob");
        member.setLastName("Smith");
        member.setEmail("bobsmith@gmail.com");
        member.setBarCode("124");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        roleSet.add(role2);
        member.setRoles(roleSet);
        memberRepository.save(member);
        roleRepository.save(role);
        roleRepository.save(role2);
    }

    @After
    public void cleanup(){
        given()
                .when()
                .delete("members/1/roles/id/1");
    }
    @Test
    public void testGetRole(){
//        Role role = new Role("student");
//        given()
//                .contentType("application/json")
//                .body(role)
//                .when().post("/books").then()
//                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("/members/{1}/roles/id/{1}")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("roleType",equalTo("student"));
//                .body("title",equalTo("Book 123"))
//                .body("price",equalTo(18.95f))
//                .body("author",equalTo("Joe Smith"));
        //cleanup

    }

    @Test
    public void testAddRole(){
        RolePayload rolePayload = new RolePayload(1,"driver");
        //add role
        given()
                .contentType("application/json")
                .body(rolePayload)
                .when()
                .post("/members/1/roles/+")
                .then()
                .statusCode(200);
         //get role
        given()
                .contentType("application/json")
//                .body(rolePayload)
                .when()
                .get("members/1/roles/1")
                .then()
                .body("roleType",equalTo("driver"));
    }

    @Test
    public void testUpdateRole(){
        RolePayload rolePayload = new RolePayload(1,"driver2");
        //add role
        given()
                .contentType("application/json")
                .body(rolePayload)
                .when()
                .put("/members/1/roles/+-")
                .then()
                .statusCode(200);
        //get role
        given()
                .contentType("application/json")
//                .body(rolePayload)
                .when()
                .get("members/1/roles/3")
                .then()
                .body("roleType",equalTo("driver2"));
    }

    @org.junit.Test
    public void testDeleteRole(){
        //get role
        given()
                .contentType("application/json")
//                .body(rolePayload)
                .when()
                .get("members/1/roles/1")
                .then()
                .body("roleType",equalTo("driver2"));
        //delete role
        given()
                .contentType("application/json")
                .when()
                .delete("members/1/roles/1")
                .then()
                .statusCode(200);
        //get role
        given()
                .contentType("application/json")
//                .body(rolePayload)
                .when()
                .get("members/1/roles/1")
                .then()
                .statusCode(204);

    }

    @Test
    public void getAllRoles(){
        //get role
        given()
                .contentType("application/json")
//                .body(rolePayload)
                .when()
                .get("members/1/roles/a")
                .then()
                .body("rolePayloads.size()",equalTo(2));
    }
}