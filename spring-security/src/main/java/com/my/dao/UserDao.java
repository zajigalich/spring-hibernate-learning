package com.my.dao;

import com.my.entity.User;

public interface UserDao {
    User findByUserName(String userName);

    void save(User user);
}
