package com.less.controller;


import com.less.dao.entity.User;
import com.less.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/queryAllUsers")
    public List<User> queryAllUsers() {
        logger.info("查询所有用户日志 {}", new Date());
        return userService.queryAllUsers();
    }

    @PostMapping(value = "/saveUser")
    public User saveUser(@RequestBody User user) throws Exception {
        try {
            userService.saveUser(user);
            return user;
        } catch (Exception e) {
            // todo
            throw new Exception(e.getMessage());
        }

    }
}
