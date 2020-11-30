package com.less.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Solution {


    public static void main(String[] args) {


    }


}

class MyClassLoader extends ClassLoader {
    private String classLoaderName;

    public MyClassLoader(String classLoaderName) {
        super(); // 将系统类加载器当作parent
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(String classLoaderName, ClassLoader parent) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = this.loadClassData(name);
        if (b == null) {
            return super.loadClass(name);
        }
        return defineClass(name, b, 0, b.length);

    }


    private byte[] loadClassData(String name) {
        InputStream in = getClass().getResourceAsStream(name.substring(name.lastIndexOf(".") + 1) + ".class");

        try {
            byte[] b = new byte[in.available()];
            in.read(b);
            return b;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class DynamicProxy {
    public static <T> T getProxy(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        before();
                        Object result = method.invoke(target, args);
                        after();
                        return result;
                    }
                });
    }

    private static void after() {
        System.out.println("after");

    }

    private static void before() {
        System.out.println("before");
    }
}



