package com.less.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil111 {
    public static Connection getConn() throws SQLException {
        /* 加载驱动。。。。。返回连接 */
        return DriverManager.getConnection("");
    }
}
