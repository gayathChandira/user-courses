package com.hms.usercourses;

import java.util.List;

public interface UserDAO {
    public User findUser(int user_id);
    public List<User> findAllUsers();
}
