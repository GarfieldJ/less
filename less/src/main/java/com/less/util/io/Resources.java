package com.less.util.io;

import java.io.InputStream;


public class Resources {

    /** 使用类加载器加载资源  */
    public static InputStream getResourceAsStream(String fileName) {
        return Resources.class.getClassLoader().getResourceAsStream(fileName);
    }


}
