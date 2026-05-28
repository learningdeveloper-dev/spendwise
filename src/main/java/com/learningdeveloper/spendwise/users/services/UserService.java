package com.learningdeveloper.spendwise.users.services;

import com.learningdeveloper.spendwise.users.dto.User;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    User selectUserById(Long id);

    User selectUserByMobileNumber(String mobileNumber);

    void deleteUser(Long id);
}
