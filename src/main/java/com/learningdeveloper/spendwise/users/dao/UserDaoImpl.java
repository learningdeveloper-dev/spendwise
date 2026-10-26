package com.learningdeveloper.spendwise.users.dao;

import com.learningdeveloper.spendwise.base.dao.BaseDao;
import com.learningdeveloper.spendwise.users.dto.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    private final BaseDao baseDao;

    public UserDaoImpl(BaseDao baseDao) {
        this.baseDao = baseDao;
    }


    @Override
    public void createUser(User user) {
        baseDao.insert("users.createUser", user);
    }

    @Override
    public void updateUser(User user) {
        baseDao.update("users.updateUser", user);
    }

    @Override
    public User selectUserById(Long id) {
        return (User) baseDao.selectOne("users.getUserById", id);
    }

    @Override
    public User selectUserByMobileNumber(String mobileNumber) {
        return (User) baseDao.selectOne("users.getUserByMobileNumber", mobileNumber);
    }

    @Override
    public void deleteUser(Long id) {
        baseDao.delete("users.deleteUserById", id);
    }

    @Override
    public User selectUserByEmailId(String emailId) {
        return (User) baseDao.selectOne("users.getUserByEmailId", emailId);
    }

    @Override
    public User selectUserByEmailIdAndPassword(String emailId, String password) {
        Map<String, String> payload = new HashMap<>();
        payload.put("emailId", emailId);
        payload.put("password", password);
        return (User) baseDao.selectOne("users.getUserByEmailIdAndPassword", payload);
    }
}
