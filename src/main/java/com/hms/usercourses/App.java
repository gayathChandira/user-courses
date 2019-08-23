package com.hms.usercourses;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class App {

    private static UserDAO userDao;
    public static void main(String[] args){

        userDao = new UserDAOImpl();

       // User user1 =

        JdbcTemplate jdbcTemplate = dbConnection.getConnection();
        String sql = "INSERT INTO user_details (f_name, l_name, age, email, contact) VALUES (?,?,?,?,?);";
        int result = jdbcTemplate.update(sql,"saman","kumara",45,"dasamn@gmail.com","09003829");
        if (result > 0) {
            System.out.println("new user added");
        }
    }
}
