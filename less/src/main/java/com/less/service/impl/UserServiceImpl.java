package com.less.service.impl;

import com.less.dao.mapper.UserMapper;
import com.less.dao.entity.User;
import com.less.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> queryAllUsers() {
        return userMapper.queryAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    /**
     * 获取用户策略：先从缓存中获取用户，没有则取数据表中 数据，再将数据写入缓存
     */
    @Override
    public User findUserById(int id) {
        String key = "user_" + id;

        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        //判断redis中是否有键为key的缓存
        boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) {
            User user = operations.get(key);
            log.info("从缓存中获得数据：{}", user.getName());
            return user;
        } else {
            User user = userMapper.findUserById(id);
            if (user == null) {
                return user;
            }
            log.info("查询数据库获得数据：{}", user.getName());

            // 写入缓存
            operations.set(key, user, 5, TimeUnit.HOURS);
            log.info("缓存新增数据：{}", user.getName());
            return user;
        }
    }

    /**
     * 更新用户策略：先更新数据表，成功之后，删除原来的缓存，再更新缓存
     */
    @Override
    public int updateUser(User user) {
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        int result = userMapper.updateUser(user);
        if (result != 0) {
            String key = "user_" + user.getId();
            boolean haskey = redisTemplate.hasKey(key);
            if (haskey) {
                redisTemplate.delete(key);
                log.info("删除缓存中的key:{}", key);
            }
            // 再将更新后的数据加入缓存
            User userNew = userMapper.findUserById(user.getId());
            if (userNew != null) {
                operations.set(key, userNew, 3, TimeUnit.HOURS);
                log.info("缓存新增数据:{}", key);
            }
        }
        return result;
    }

    /**
     * 删除用户策略：删除数据表中数据，然后删除缓存
     */
    @Override
    public int deleteUserById(int id) {
        int result = userMapper.deleteUserById(id);
        String key = "user_" + id;
        if (result != 0) {
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                redisTemplate.delete(key);
                log.info("删除了缓存中的key:{}", key);
            }
        }
        return result;
    }
}
