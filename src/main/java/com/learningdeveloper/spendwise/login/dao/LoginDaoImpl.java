package com.learningdeveloper.spendwise.login.dao;

import com.learningdeveloper.spendwise.base.exceptions.UserCreationException;
import com.learningdeveloper.spendwise.base.exceptions.UserDoesNotExist;
import com.learningdeveloper.spendwise.login.dto.SignupDTO;
import com.learningdeveloper.spendwise.users.dto.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginDaoImpl implements LoginDao {

    private final SqlSessionTemplate sqlSessionTemplate;

    public LoginDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public User login(SignupDTO signupDTO) {
        Integer userExist = this.sqlSessionTemplate.selectOne("users.userExists", signupDTO);
        if (userExist == 1) {
            signupDTO.setPassword(null);
        } else {
            throw new UserDoesNotExist("Email: %s or Mobile Number: %s does not exist".formatted(signupDTO.getEmailId(), signupDTO.getMobileNumber()));
        }
        return signupDTO;
    }

    @Override
    public User signUp(SignupDTO signupDTO) {
        int success = this.sqlSessionTemplate.insert("users.createUser", signupDTO);
        signupDTO.setPassword(null);
        if (success != 1) {
            throw new UserCreationException("Error creating user : %s".formatted(signupDTO));
        }
        return signupDTO;
    }

}
