package ltd.newbee.mall.test.miaosha;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-06-06 11:17
 **/
public class Test {

    public static void main(String[] args) {
        ClassLoader classLoader = StringBuilder.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);
    }

}