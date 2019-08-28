package com.hms.usercourses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@RestController
@Repository
@RequestMapping("/users")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List users = new ArrayList<>();

    final String selectById = "SELECT * FROM user_details WHERE user_id = ?";
    final String insertSql = "INSERT INTO user_details (f_name,l_name,age,email,contact) VALUES (?,?,?,?,?)";
    final String findAll = "SELECT * FROM user_details";
    final String editUser = "UPDATE user_details SET f_name=?, age=? WHERE user_id=?";
    final String deleteUser = "DELETE FROM user_details WHERE user_id=?";


    @Override
    @GetMapping("/user")
    public User findUser(@RequestParam("id") int user_id) {
        return jdbcTemplate.queryForObject(selectById, new UserMapper(), user_id);
    }

    @Override
    @GetMapping("/all")
    public List<User> findAllUsers() {
        return jdbcTemplate.query(findAll, new UserMapper());
    }

    @Override
    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public User addUser(User user) {
        jdbcTemplate.update(insertSql, user.getF_name(), user.getL_name(), user.getAge(), user.getEmail(), user.getContact());
        return user;
    }

    @Override
    @PutMapping(path = "/edit", consumes = "application/x-www-form-urlencoded")
    public User editUser(User user) {
        jdbcTemplate.update(editUser, user.getF_name(), user.getAge(), user.getUser_id());
        return user;
    }

    @Override
    @DeleteMapping(value = "/delete", consumes = "application/x-www-form-urlencoded")
    public boolean deleteUser(User user) {
        return jdbcTemplate.update(deleteUser, user.getUser_id()) == 1;
    }

    private static final class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User usr = new User();
            usr.setUser_id(rs.getInt("user_id"));
            usr.setF_name(rs.getString("f_name"));
            usr.setL_name(rs.getString("l_name"));
            usr.setAge(rs.getInt("age"));
            usr.setEmail(rs.getString("email"));
            usr.setContact(rs.getString("contact"));
            return usr;
        }
    }


}
