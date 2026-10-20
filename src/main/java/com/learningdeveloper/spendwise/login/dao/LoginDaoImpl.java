package com.learningdeveloper.spendwise.login.dao;

import com.learningdeveloper.spendwise.base.utils.CommonUtil;
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
        User user = this.sqlSessionTemplate.selectOne("users.doesUserExistsByMobileNumberOrEmailId", signupDTO);
        if (user == null) {
            throw new UserDoesNotExist("Please recheck the username and password.");
        }
        return user;
    }

    @Override
    public Integer signUp(SignupDTO signupDTO) {
        CommonUtil.setCreationAudit(signupDTO, signupDTO.getUserId());
        int success = this.sqlSessionTemplate.insert("users.createUser", signupDTO);
        if (success != 1) {
            throw new UserCreationException("Error creating user : %s".formatted(signupDTO));
        }
        return success;
    }

}
