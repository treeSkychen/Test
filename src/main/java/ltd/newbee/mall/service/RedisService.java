package ltd.newbee.mall.service;

import ltd.newbee.mall.entity.UserLike;
import ltd.newbee.mall.entity.dto.LikedCountDTO;

import java.util.List;

/**
 * @program: newbee-mall
 * @description: redis 实现点赞接口
 * 设点赞人的 id 为 likedPostId，被点赞人的 id 为 likedUserId ，
 * 点赞时状态为 1，取消点赞状态为 0。将点赞人 id 和被点赞人 id 作为键，两个 id 中间用 :: 隔开，点赞状态作为值。
 * @author: chenshutian
 * @create: 2021-03-15 19:17
 **/
public interface RedisService {

    /**
     *  点赞状态为 1
     * @param likedPostId 点赞人
     * @param likedUserId 被点赞人
     */
    void saveLiked2Redis(String likedUserId, String likedPostId);

    /**
     * 取消点赞
     * @param likedPostId
     * @param likedUserId
     */
    void unLikedFromRedis(String likedUserId, String likedPostId);

    /**
     * 从redis中删除一条点赞数据
     * @param likedUserId
     * @param likedPostId
     */
    void deleteLikedFromRedis(String likedUserId, String likedPostId);

    /**
     * 该用户点赞数+1
     * @param likedUserId
     */
    void incrementLikedCount(String likedUserId);

    /**
     * 该用户点赞数-1
     * @param likedUserId
     */
    void decrementLikedCount(String likedUserId);

    /**
     * 获取Redis中存储的所有点赞数据
     * @return
     */
    List<UserLike> getLikedDataFromRedis();

    /**
     * 获取Redis中存储的所有点赞数量
     * @return
     */
    List<LikedCountDTO> getLikedCountFromRedis();
}
