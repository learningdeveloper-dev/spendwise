package com.learningdeveloper.spendwise.jwt.dao;

public interface JwtDao {

    int insertRefreshToken(String userId, String refreshToken);
    int updateRefreshToken(String userId, String refreshToken);
    int selectRefreshToken(String userId, String refreshToken);
}
