package ltd.newbee.mall.demo1;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-04-01 10:38
 **/
@Service("B")
public class AbstractMessageTemplateImpl2 implements AbstractMessageTemplate {

    @Override
    public Map<String, String> getData(List<String> string) {
        System.out.println("BBBBBBBBB");
        string.forEach(System.out::println);
        return null;
    }
}
