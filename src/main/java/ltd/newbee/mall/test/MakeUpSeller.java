package ltd.newbee.mall.test;

import javax.lang.model.element.VariableElement;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 静态代理，定义一个买化妆品的接口
 */
public interface MakeUpSeller {
    //销售方法。name为化妆品的名字，price是价格
    void sell(String name, double price);
}

//原对象—————YSL官方商店
class YslSeller implements MakeUpSeller {

    @Override
    public void sell(String name, double price) {
        System.out.println("感谢购买" + name + ",一共是" + price + "元");
    }
}

//代理对象————微商代理YSL官方商店
class WeiShangProxy implements InvocationHandler {
    //持有元对象的引用
    private MakeUpSeller makeUpSeller;


    public WeiShangProxy(MakeUpSeller makeUpSeller) {
        this.makeUpSeller = makeUpSeller;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我要发朋友圈,介绍商品优势");
        //YSL官方商店对象调用卖产品的接口
        method.invoke(makeUpSeller, args);
        System.out.println("并送您一瓶卸妆水，欢迎下次再来");
        return null;
    }
}

class ProxyTest {
    public static void main(String[] args) {
        MakeUpSeller ys = (MakeUpSeller) Proxy.newProxyInstance(MakeUpSeller.class.getClassLoader(), new Class[]{MakeUpSeller.class}, new WeiShangProxy(new YslSeller()));
        ys.sell("ysl口红", 100);
    }
}
