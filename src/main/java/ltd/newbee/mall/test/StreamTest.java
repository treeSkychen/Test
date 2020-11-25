package ltd.newbee.mall.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:静态代理
 * @author: chenshutian
 * @create: 2020-05-23 10:39
 **/
@RequestMapping
@RestController
public class StreamTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "线程开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "线程结束");
        };

        Thread t = new Thread(r, "线程1");
        Thread t1 = new Thread(r, "线程2");
        t.start();
        t1.start();
    }


}

class DeadThread {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + "初始化当前类");

            while (true) {

            }
        }
    }
}

class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);
        //获取上层扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println("parent = " + parent);

        //获取上层
        ClassLoader bootstrapClassLoader = parent.getParent();
        System.out.println("bootstrapClassLoader = " + bootstrapClassLoader);

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println("classLoader1 = " + classLoader1);
        ClassLoader classLoader2 = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader2);
        try {
            ClassLoader classLoader3 = Class.forName("java.lang.String").getClassLoader();
            System.out.println("classLoader3 = " + classLoader3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class StaticTest {
    static {
        int a = 100;
        System.out.println("随着类的初始化赋值");
        System.out.println("a = " + a);
    }

    public void jvbu() {
        int a;
//        System.out.println("a = " + a); 局部变量必须要赋值
    }

    public void testStack() {
        int i = 8;
        int k = 9;
        int j = i + k;
    }
}