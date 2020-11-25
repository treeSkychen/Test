package ltd.newbee.mall.controller.mall;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-11-24 16:12
 **/
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        return "健康检查";
    }
}