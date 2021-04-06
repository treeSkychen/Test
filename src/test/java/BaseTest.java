import ltd.newbee.mall.demo1.AbstractMessageTemplate;
import ltd.newbee.mall.demo1.TemplateContext;
import ltd.newbee.mall.NewBeeMallApplication;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Map;

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
    @Autowired
    private TemplateContext templateContext;


    @Test
    public void test1() {
        System.out.println(newBeeMallGoods.getNewBeeMallGoodsById(1L));
    }

    @Test
    public void test2() {
        AbstractMessageTemplate abstractMessageTemplate = templateContext.get("A");
        abstractMessageTemplate.getData(Arrays.asList("1","2","3"));
    }


}