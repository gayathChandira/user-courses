package com.hms.usercourses;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppTest
{
    @Test
    public void findByIdTest(){
        JdbcTemplate jdbcTemplate = dbConnection.getConnection();

        UserDAOImpl dao = new UserDAOImpl();
        User usr = dao.findUser(1);
        System.out.println("User name : "+ usr.getF_name());
    }
}
