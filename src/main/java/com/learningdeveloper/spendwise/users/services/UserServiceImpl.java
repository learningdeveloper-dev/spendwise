package com.learningdeveloper.spendwise.users.services;

import com.learningdeveloper.spendwise.users.dao.UserDao;
import com.learningdeveloper.spendwise.users.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User selectUserById(Long id) {
        return userDao.selectUserById(id);
    }

    @Override
    public User selectUserByMobileNumber(String mobileNumber) {
        return userDao.selectUserByMobileNumber(mobileNumber);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

}
