package com.hms.usercourses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    private List users = new ArrayList<>();

    final String selectById = "SELECT * FROM user_details WHERE user_id = ?";
    final String insertSql = "INSERT INTO user_details (f_name,l_name,age,email,contact) VALUES (?,?,?,?,?)";

    JdbcTemplate jdbcTemplate = dbConnection.getConnection();

    @Override
    public User findUser(int user_id) {
        return this.jdbcTemplate.queryForObject(selectById, new UserMapper(), user_id);
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public int addUser(User user) {
        return this.jdbcTemplate.update(insertSql,user.getF_name(),user.getL_name(),user.getAge(),user.getEmail(),user.getContact());
    }

    private static final class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User usr = new User();
            usr.setUser_id(rs.getInt("user_id"));
            usr.setF_name(rs.getString("f_name"));
            usr.setL_name(rs.getString("l_name"));
            usr.setAge(rs.getInt("age"));
            usr.setEmail(rs.getString("email"));
            return usr;
        }
    }


}
