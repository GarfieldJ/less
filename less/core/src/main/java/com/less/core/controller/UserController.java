package com.less.core.controller;


import com.less.core.dao.entity.User;
import com.less.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public List<User> queryAllUsers() {
        logger.info("查询所有用户日志 {}", new Date());
        return userService.queryAllUsers();
    }

    @PostMapping(value = "")
    public User saveUser(@RequestBody User user) throws Exception {
        try {
            userService.saveUser(user);
            return user;
        } catch (Exception e) {
            // todo
            throw new Exception(e.getMessage());
        }

    }

    @PutMapping(value = "")
    public User updateUser(@RequestBody User user) throws Exception {
        try {
            userService.updateUser(user);
            return user;
        } catch (Exception e) {
            // todo
            throw new Exception(e.getMessage());
        }

    }

    @GetMapping(value = "/{id}")
    public User findUserById(@PathVariable Integer id) throws Exception {
        try {
            return userService.findUserById(id);
        } catch (Exception e) {
            // todo
            throw new Exception(e.getMessage());
        }

    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Integer id) throws Exception {
        try {
            userService.deleteUserById(id);
        } catch (Exception e) {
            // todo
            throw new Exception(e.getMessage());
        }

    }
}
