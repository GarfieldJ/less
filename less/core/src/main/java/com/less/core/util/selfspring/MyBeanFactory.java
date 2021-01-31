package com.less.core.util.selfspring;

import com.less.core.controller.Alive;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MyBeanFactory {
    /* 配置 */
    private static Properties prop;

    /* 存对象容器 */
    private static Map<String, Object> beans;

    static {
        prop = new Properties();
        try (InputStream in = MyBeanFactory.class.getClassLoader().getResourceAsStream("bean.properties")) {
            prop.load(in);
            beans = new HashMap<>();
            Enumeration<Object> keys = prop.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = prop.getProperty(key);
                beans.put(key, Class.forName(beanPath).newInstance());
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties错误");
        }

    }

    public static Object getBean(String beanName) {
        Object bean = null;
        try {
            bean = beans.get(beanName);
            if (bean == null) {
                synchronized (MyBeanFactory.class) {
                    bean = beans.get(beanName);
                    if (bean == null) {
                        String beanPath = prop.getProperty(beanName);
                        bean = Class.forName(beanPath).newInstance();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static void main(String[] args) {
        Alive alive = (Alive) MyBeanFactory.getBean("alive");
        Alive alive2 = (Alive) MyBeanFactory.getBean("alive");

        System.out.println(alive == alive2);

    }

}
