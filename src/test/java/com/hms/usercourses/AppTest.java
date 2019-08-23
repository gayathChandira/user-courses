package com.hms.usercourses;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
public class AppTest {


    @Test
    public void findByIdTest() {
        UserDAOImpl dao = new UserDAOImpl();
        User usr = dao.findUser(1);
        System.out.println("User name : " + usr.getF_name());
        assertThat("sunil").isEqualTo(usr.getF_name());
    }

    @Test
    public void addUserTest(){

    }


}
