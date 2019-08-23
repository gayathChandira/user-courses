package com.hms.usercourses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserDAOImplTest {

    @Test
    void findUser() {
    }

    @Test
    void findAllUsers() {
    }

    @Test
    void addUser() {
        UserDAOImpl dao = new UserDAOImpl();
        User usr = new User();
        usr.setF_name("pasan");
        usr.setL_name("perera");
        usr.setAge(23);
        usr.setEmail("pasan@gmail.com");
        usr.setContact("071189020");

        int status = dao.addUser(usr);
        System.out.println(status);
        assertThat(1).isEqualTo(status);
    }
}