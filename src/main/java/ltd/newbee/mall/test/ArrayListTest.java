package ltd.newbee.mall.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-03-16 16:38
 **/
public class ArrayListTest {
//    static List<String> list = new ArrayList();//线程不安全
//    static List<String> list = new Vector<>();//线程线程安全
//    static List<String> list = Collections.synchronizedList(new ArrayList());//线程安全


    public static void main(String[] args) {
//        List<String> list = new ArrayList();//线程不安全 因为一个方法中多个线程操作同一个对象
        List<String> list = Collections.synchronizedList(new ArrayList());
        for (int i = 0; i < 10; i++) {
            int a = i;
            new Thread(() -> {
                list.add(a + "");
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
