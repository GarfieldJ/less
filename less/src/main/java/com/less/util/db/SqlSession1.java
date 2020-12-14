package com.less.util.db;

import java.io.Closeable;
import java.io.IOException;

public interface SqlSession1 extends Closeable {

    <T> T getMapper(Class<?> c);

    @Override
    public void close();
}
