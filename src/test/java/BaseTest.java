import ltd.newbee.mall.NewBeeMallApplication;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-11-30 16:14
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewBeeMallApplication.class)
public class BaseTest {

    @Autowired
    private NewBeeMallGoodsService newBeeMallGoods;

    @Test
    public void test1() {
        System.out.println(newBeeMallGoods.getNewBeeMallGoodsById(1L));
    }


}