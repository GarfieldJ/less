package com.less.util;


import java.util.List;

public interface MyMapper<T>  {
    List<T> findAll();

}