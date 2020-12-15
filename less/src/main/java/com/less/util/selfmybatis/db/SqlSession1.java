package com.less.util.selfmybatis.db;

import java.io.Closeable;

public interface SqlSession1 extends Closeable {

    <T> T getMapper(Class<?> c);

    @Override
    public void close();
}
