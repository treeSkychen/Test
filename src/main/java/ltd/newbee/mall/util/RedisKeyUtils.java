package ltd.newbee.mall.util;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-03-15 19:21
 **/
public class RedisKeyUtils {

    //保存用户点赞数据的key
    public static final String MAP_KEY_USER_LIKED = "MAP_USER_LIKED";
    //保存用户被点赞数量的key
    public static final String MAP_KEY_USER_LIKED_COUNT = "MAP_USER_LIKED_COUNT";

    public static String getLikedKey(String likedUserId, String likedPostId) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(likedUserId);
        stringBuffer.append("::");
        stringBuffer.append(likedPostId);
        return stringBuffer.toString();
    }
}
