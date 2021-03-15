package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.entity.LikedStatusEnum;
import ltd.newbee.mall.entity.UserLike;
import ltd.newbee.mall.entity.dto.LikedCountDTO;
import ltd.newbee.mall.service.RedisService;
import ltd.newbee.mall.util.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-03-15 19:20
 **/
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 该用户点赞数+1
     *
     * @param likedUserId
     */
    @Override
    public void incrementLikedCount(String likedUserId) {
        redisTemplate.opsForHash().increment(RedisKeyUtils.MAP_KEY_USER_LIKED_COUNT, likedUserId, 1);
    }

    /**
     * 该用户点赞数-1
     *
     * @param likedUserId
     */
    @Override
    public void decrementLikedCount(String likedUserId) {
        redisTemplate.opsForHash().increment(RedisKeyUtils.MAP_KEY_USER_LIKED_COUNT, likedUserId, -1);
    }

    /**
     * 获取Redis中存储的所有点赞数据
     *
     * @return
     */
    @Override
    public List<UserLike> getLikedDataFromRedis() {
        Cursor<Map.Entry<Object, Object>> scan = redisTemplate.opsForHash().scan(RedisKeyUtils.MAP_KEY_USER_LIKED, ScanOptions.NONE);
        List<UserLike> list = new ArrayList<>();
        while (scan.hasNext()) {
            Map.Entry<Object, Object> entry = scan.next();
            String key = (String) entry.getKey();
            String[] split = key.split("::");
            String likedUserId = split[0];//被点赞的人
            String likedPostId = split[1];//点赞的人
            String value = (String) entry.getValue();
            UserLike userLike = UserLike.builder().likedPostId(likedPostId).likedUserId(likedUserId).status(Integer.parseInt(value)).build();
            list.add(userLike);
            //存储到list从redis中删除
            redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_LIKED, key);
        }
        return list;
    }

    /**
     * 获取Redis中存储的所有点赞数量
     *
     * @return
     */
    @Override
    public List<LikedCountDTO> getLikedCountFromRedis() {
        Cursor<Map.Entry<Object, Object>> scan = redisTemplate.opsForHash().scan(RedisKeyUtils.MAP_KEY_USER_LIKED_COUNT, ScanOptions.NONE);
        List<LikedCountDTO> list = new ArrayList<>();
        while (scan.hasNext()) {
            Map.Entry<Object, Object> map = scan.next();
            String key = (String) map.getKey();
            LikedCountDTO likedCountDTO = new LikedCountDTO(key,Integer.parseInt(map.getValue().toString()));
            list.add(likedCountDTO);
            //从redis中删除这条记录
            redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_LIKED_COUNT, key);
        }
        return list;
    }

    /**
     * 取消点赞
     *
     * @param likedPostId
     * @param likedUseId
     */
    @Override
    public void unLikedFromRedis(String likedUseId, String likedPostId) {
        String key = RedisKeyUtils.getLikedKey(likedUseId, likedPostId);
        redisTemplate.opsForHash().put(RedisKeyUtils.MAP_KEY_USER_LIKED, key, LikedStatusEnum.UNLIKE.getCode());
    }

    /**
     * 从redis中删除一条点赞数据
     *
     * @param likedUserId
     * @param likedPostId
     */
    @Override
    public void deleteLikedFromRedis(String likedUserId, String likedPostId) {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likedPostId);
        redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_LIKED, key);
    }

    /**
     * 点赞状态为 1
     *
     * @param likedPostId 点赞人
     * @param likedUseId  被点赞人
     */
    @Override
    public void saveLiked2Redis(String likedUseId, String likedPostId) {
        String key = RedisKeyUtils.getLikedKey(likedUseId,likedPostId );
        redisTemplate.opsForHash().put(RedisKeyUtils.MAP_KEY_USER_LIKED, key, LikedStatusEnum.LIKE.getCode()+"");
    }
}
