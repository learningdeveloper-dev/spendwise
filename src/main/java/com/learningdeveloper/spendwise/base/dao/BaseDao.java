package com.learningdeveloper.spendwise.base.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public Object insert(String statement, Object parameter) {
        return this.sqlSessionTemplate.insert(statement, parameter);
    }

    public Object delete(String statement, Object parameter) {
        return this.sqlSessionTemplate.delete(statement, parameter);
    }

    public Object update(String statement, Object parameter) {
        return this.sqlSessionTemplate.update(statement, parameter);
    }

    public Object selectOne(String statement, Object parameter) {
        return this.sqlSessionTemplate.selectOne(statement, parameter);
    }

}
