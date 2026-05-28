package com.learningdeveloper.spendwise.users.dao;

import com.learningdeveloper.spendwise.users.dto.User;

public interface UserDao {
    void createUser(User user);

    void updateUser(User user);

    User selectUserById(Long id);

    User selectUserByMobileNumber(String mobileNumber);

    void deleteUser(Long id);
}
