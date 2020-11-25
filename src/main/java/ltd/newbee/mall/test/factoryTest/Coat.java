package ltd.newbee.mall.test.factoryTest;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-05-25 19:59
 **/
public class Coat implements Pige {

    private String name;
    private String price;

    public Coat(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void name() {
        System.out.println("name = " + name);
    }

    @Override
    public void price() {
        System.out.println("price = " + price);
    }
}