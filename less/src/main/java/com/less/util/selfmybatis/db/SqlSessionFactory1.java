package com.less.util.selfmybatis.db;


import java.sql.SQLException;

public class SqlSessionFactory1 {
    Configuration cf;

    public SqlSessionFactory1() {
    }

    public SqlSessionFactory1(SqlSessionFactoryBuilder1 builder1) {
        this.cf = builder1.cf;
    }

    public SqlSession1 openSession() throws SQLException {
        Configuration cf = new Configuration();
        return new DefaultSqlSession1(cf);
    }

    public Configuration getCf() {
        return cf;
    }

    public void setCf(Configuration cf) {
        this.cf = cf;
    }


    /**  建造者模式 */
    static final class SqlSessionFactoryBuilder1 {
        Configuration cf;

        public SqlSessionFactoryBuilder1() {
        }

        public SqlSessionFactoryBuilder1 setCf(Configuration cf) {
            this.cf = cf;
            return this;
        }

        public SqlSessionFactory1 build() {
            return new SqlSessionFactory1();
        }
    }

}


