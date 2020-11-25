package ltd.newbee.mall.test.factoryTest;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-05-25 19:57
 **/
public class Wallet implements Pige {
    private String name;
    private String price;

    public Wallet(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void name() {

        System.out.println("名字：" + name);
    }

    @Override
    public void price() {

        System.out.println("价格：" + price);
    }
}