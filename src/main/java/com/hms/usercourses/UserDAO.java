package com.hms.usercourses;

import java.util.List;

public interface UserDAO {
    /**
     * @param user_id
     * @return user
     */
    public User findUser(int user_id);

    /**
     * @return User
     */
    public List<User> findAllUsers();


    /**
     * @param user
     * @return
     */
    public User addUser(User user);

    /**
     *
     * @param user
     * @return user
     */
    public User editUser(User user);

    /**
     *
     * @param user
     * @return
     */
    public boolean deleteUser(User user);
}
