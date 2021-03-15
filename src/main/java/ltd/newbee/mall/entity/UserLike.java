package ltd.newbee.mall.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-03-15 20:00
 **/
@Data
@Builder
public class UserLike {

    private Integer id;
    //被点赞的用户的id
    private String likedUserId;
    //点赞的用户的id
    private String likedPostId;
    //点赞的状态.默认未点赞
    private Integer status = LikedStatusEnum.UNLIKE.getCode();


}
