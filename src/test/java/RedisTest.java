import com.alibaba.fastjson.JSON;
import domain.Days;
import ltd.newbee.mall.entity.UserLike;
import ltd.newbee.mall.entity.dto.LikedCountDTO;
import ltd.newbee.mall.service.RedisService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-03-15 18:12
 **/
public class RedisTest extends BaseTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private Days d;
    @Autowired
    private RedisService redisService;

    @Before
    public void set() {
        d = new Days();
        d.setDate("123");
        d.setDaysId("456");
        d.setItemNumber(123);
        d.setOpenId("dawda");
        d.setTitle("title");
    }

    @Test
    public void testRedis() {
        Object o = JSON.toJSON(JSON.toJSON(d));
        this.redisTemplate.opsForValue().set("days", JSON.toJSON(d).toString());
    }

    @Test
    public void dianZan1() {
//        redisService.saveLiked2Redis("1","2");
//        redisService.incrementLikedCount("1");
//        List<LikedCountDTO> likedCountFromRedis = redisService.getLikedCountFromRedis();
//        System.out.println("likedCountFromRedis = " + likedCountFromRedis);
        List<UserLike> likedDataFromRedis = redisService.getLikedDataFromRedis();
        System.out.println("likedDataFromRedis = " + likedDataFromRedis);
    }

}
