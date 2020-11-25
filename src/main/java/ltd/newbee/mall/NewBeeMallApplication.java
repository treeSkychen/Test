package ltd.newbee.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link https://github.com/newbee-ltd
 */
@MapperScan("ltd.newbee.mall.dao")
@SpringBootApplication
public class NewBeeMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewBeeMallApplication.class, args);
    }
}
