package ltd.newbee.mall.test.factoryTest;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-05-25 19:55
 **/
public class gongchang {
    public static Pige getSkin(String name) {
        if (name.equals("真皮钱包")) {
            return new Wallet("真皮钱包", "800￥");
        } else if (name.equals("貂皮大衣")) {
            return new Coat("貂皮大衣", "999￥");
        } else {
            return null;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Pige jj = gongchang.getSkin("真皮钱包");
        jj.name();
        jj.price();
        System.out.println("jj = " + jj);
    }
}