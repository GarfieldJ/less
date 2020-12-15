package com.less.dao.mapper;


import com.less.dao.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
@CacheNamespace(blocking = true)
public interface UserMapper {

    @Select(value = "select * from user")
    List<User> queryAllUsers();

    @Insert(value = "insert into user(name, id_card, phone, password) values(#{name}," +
            " #{idCard}, #{phone}, #{password})")
    @SelectKey(statement = "select last_insert_id()" , keyProperty="id", keyColumn="id", resultType=Integer.class,
            before=false)
    void saveUser(User user);

    @Update(value= "update user set name=#{name}, id_card=#{idCard},phone=#{phone},password=#{password} where id = #{id}")
    void updateUser(User user);

    @Delete(value= "delete from user where id = #{id}")
    void deleteUser(int id);
}
