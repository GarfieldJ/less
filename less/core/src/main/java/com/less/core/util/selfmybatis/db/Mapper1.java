package com.less.core.util.selfmybatis.db;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class Mapper1 implements InvocationHandler {
    private Map<String, Mapper1> mappers;
    private Connection conn;

    public Mapper1(Map<String, Mapper1> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String className = method.getDeclaringClass().getName();
        String key = className + "." + method.getName();
        Mapper1 mapper1 = mappers.get(key);
        if (mapper1 == null) {
            throw new IllegalArgumentException();
        }

        /* 调用工具类执行查询所有， 此处接口没有具体实现类，需要(反射获取注解内容/xml配置方式则从xml中读取)，执行 */
        return null;// return MyUtil1.selectList(mapper1, conn);
    }
}
