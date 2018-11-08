package com.news.dao;

import com.news.entity.UserEntity;

public interface UserDAO {
    boolean createUser(UserEntity userEntity);
    boolean deleteUser(UserEntity userEntity);
}

