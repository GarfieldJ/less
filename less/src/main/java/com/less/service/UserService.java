package com.less.service;

import com.less.dao.entity.User;

import java.util.List;

public interface UserService {


    List<User> queryAllUsers();

    void saveUser(User user);

    User findUserById(int id);

    int updateUser(User user);

    int deleteUserById(int id);
}
