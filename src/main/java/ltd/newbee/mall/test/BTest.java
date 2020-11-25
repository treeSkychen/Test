package ltd.newbee.mall.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-06-07 08:04
 **/
public class BTest {
    private int num;

    public void methodA() {
        System.out.println("methodA（）开始调用");
//        return 1;
    }

    public void methodB() {
        System.out.println("methodB（）开始调用");

        methodA();
        num++;
    }

    public static void main(String[] args) {
        ClassLoader classLoader = BTest.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println("parent = " + parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println("parent1 = " + parent1);
    }

}

class A {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -15);
        Date date = c.getTime();
        System.out.println(format.format(date));

        System.out.println(format.format(new Date()));
    }
}
