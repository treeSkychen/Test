package ltd.newbee.mall.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-04-01 10:27
 **/
@Component
public class TemplateContext {
    public static Map<String, AbstractMessageTemplate> map = new ConcurrentHashMap();

    public TemplateContext(Map<String, AbstractMessageTemplate> map) {
        TemplateContext.map.clear();
        map.forEach((k, v) -> {
            TemplateContext.map.put(k, v);
        });
    }

    public AbstractMessageTemplate get(String key) {
        return map.get(key);
    }

}
