package com.learningdeveloper.spendwise.users.dao;

import com.learningdeveloper.spendwise.users.dto.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void createUser(User user) {
        this.sqlSessionTemplate.insert("users.createUser", user);
    }

    @Override
    public void updateUser(User user) {
        this.sqlSessionTemplate.update("users.updateUser", user);
    }

    @Override
    public User selectUserById(Long id) {
        return this.sqlSessionTemplate.selectOne("users.getUserById", id);
    }

    @Override
    public User selectUserByMobileNumber(String mobileNumber) {
        return this.sqlSessionTemplate.selectOne("users.getUserByMobileNumber", mobileNumber);
    }

    @Override
    public void deleteUser(Long id) {
        this.sqlSessionTemplate.delete("users.deleteUserById", id);
    }
}
