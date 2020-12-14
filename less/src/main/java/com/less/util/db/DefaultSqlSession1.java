package com.less.util.db;



import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession1 implements SqlSession1 {
    private Configuration cfg; // 自定义类，存放对象关系映射
    private Connection conn;

    public DefaultSqlSession1(Configuration cfg) throws SQLException {
        this.cfg = cfg;
        conn = DBUtil111.getConn();
    }

    @Override
    public <T> T getMapper(Class<?> c) {
        return (T) Proxy.newProxyInstance(c.getClassLoader(), new Class[]{c},
                new Mapper1(cfg.getMappers(), conn));
    }

    @Override
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
