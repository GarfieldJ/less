package com.less.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.concurrent.*;


public class Solution {

    static ExecutorService pool = new ThreadPoolExecutor(3,
            5,10, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());

    static Logger log = LoggerFactory.getLogger(Solution.class);
    static java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("TestLog");
    Executor pool2 = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws InterruptedException, IOException {



//        MyMapper<User> myMapper = sqlSession.getMapper(MyMapper.class);
//        List<User> users = myMapper.findAll();
//        sqlSession.commit();
//
//        sqlSession.close();
//        in.close();
//
//        new Thread(()-> {
//            /* 客户端 */
//            Socket socket = null;
//            try {
//                socket = new Socket("localhost", 1111);
//                System.out.println(socket.getLocalPort());
//
//                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//                // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//                    bw.write( "11111");
//
//                    System.out.println("输入完毕");
//                    Thread.sleep(5000);
//                    bw.close();
//
//
//
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(()-> {
//            /* 服务器 */
//            ServerSocket socket = null;
//            Socket socket1 = null;
//            try {
//                socket = new ServerSocket(1111);
//                while (true) {
//                    socket1 = socket.accept();
//                    System.out.println(socket1.getPort());
//                    BufferedReader in = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
//                    String li;
//                    System.out.println("接收数据");
//                    while ((li = in.readLine()) != null) {
//                        System.out.println(in.readLine());
//
//                    }
//                    System.out.println("接收完毕");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//
//        Thread.sleep(100*1000);
//
//        System.exit(0);
//        MyTread a = new MyTread();
//        try {
//            MyTread b = a.clone();
//
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//
//
//
//
//
//
//        Callable<String> f =  () -> {
//            Thread.sleep(10000);
//            return   (1+1+"");
//        };
//
//        String r = "";
//        Future<String> f1 = pool.submit(f);
//        try {
//            System.out.println(f1.get());
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(222222);
//
//        Lock lock = new ReentrantLock();
//        lock.newCondition();
//        lock.lock();
//        try {
//
//        } finally {
//            lock.unlock();
//        }

    }


    public float print() {
        return 1.0f;
    }

}

class MyTread implements Serializable, Cloneable {
    private ArrayList<MyTread> ll = new ArrayList<>();

    public Object readResolve() {
        return this;
    }

    public MyTread clone() throws CloneNotSupportedException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream o = new ObjectOutputStream(byteArrayOutputStream)) {
            o.writeObject(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream in = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try (ObjectInputStream in2 = new ObjectInputStream(in)) {
            MyTread o = (MyTread) in2.readObject();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        MyTread m = (MyTread) super.clone();
        m.ll = (ArrayList<MyTread>) this.ll.clone();
        return m;
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



