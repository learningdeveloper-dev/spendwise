package com.learningdeveloper.spendwise.jwt.dao;

import com.learningdeveloper.spendwise.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JwtDaoImpl extends BaseDao implements JwtDao {

    private final BaseDao baseDao;

    public JwtDaoImpl(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int insertRefreshToken(String userId, String refreshToken) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("userId", userId);
        parameterMap.put("refreshToken", refreshToken);
        return baseDao.insert("jwt.insertRefreshToken", parameterMap);
    }

    @Override
    public int updateRefreshToken(String userId, String refreshToken) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("userId", userId);
        parameterMap.put("refreshToken", refreshToken);
        return baseDao.update("jwt.updateRefreshToken", parameterMap);
    }

    @Override
    public int selectRefreshToken(String userId, String refreshToken) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("userId", userId);
        parameterMap.put("refreshToken", refreshToken);
        return (int) baseDao.selectOne("jwt.fetchRefreshToken", parameterMap);
    }

}
