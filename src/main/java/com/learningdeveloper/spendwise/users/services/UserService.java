package com.learningdeveloper.spendwise.users.services;

import com.learningdeveloper.spendwise.users.dto.User;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    User selectUserById(String id);

    User selectUserByMobileNumber(String mobileNumber);

    User selectUserByEmailId(String emailId);

    void deleteUser(String id);

    User selectUserByEmailIdAndPassword(String emailId, String password);
}
