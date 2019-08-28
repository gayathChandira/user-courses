package com.hms.usercourses;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Repository

class UserDAOImplTest {
    @Autowired
    private UserDAOImpl dao;

    @Test
    void findUser() {
        User usr = dao.findUser(1);
        System.out.println("User name : " + usr.getF_name());
        assertThat("Pradeep").isEqualTo(usr.getF_name());
    }

    @Test
    void findAllUsers() {
        List<User> usr = dao.findAllUsers();
        assertThat(usr).isNotNull();
        User result = usr.get(0);
        assertThat(result).hasFieldOrPropertyWithValue("f_name", "Pradeep");
    }

    @Test
    void addUser() {

        User usr = new User();
        usr.setF_name("pasan");
        usr.setL_name("perera");
        usr.setAge(23);
        usr.setEmail("pasan@gmail.com");
        usr.setContact("071189020");

        User result = dao.addUser(usr);
        System.out.println(result);
        assertThat(usr).isEqualTo(result);
    }

    @Test
    void editUser() {
        User usr = dao.findUser(1);
        System.out.println("before edit: " + usr.getF_name() + usr.getAge() + usr.getUser_id());
        usr.setF_name("Pradeep");
        usr.setAge(56);
        usr.setUser_id(1);
        User result = dao.editUser(usr);
        System.out.println("after edit: " + result.getF_name() + result.getAge() + result.getUser_id());
    }

    @Test
    void deleteUser(){
        User usr = new User();
        usr.setUser_id(6);
        assertThat(dao.deleteUser(usr)).isTrue();
    }
}