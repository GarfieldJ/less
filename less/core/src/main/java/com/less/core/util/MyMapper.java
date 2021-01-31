package com.less.core.util;


import java.util.List;

public interface MyMapper<T> {
    List<T> findAll();

}