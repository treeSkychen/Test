package ltd.newbee.mall.entity;

import lombok.Data;
import lombok.Getter;

/**
 * @program: newbee-mall
 * @description: 点在状态枚举
 * @author: chenshutian
 * @create: 2021-03-15 19:24
 **/
@Getter
public enum LikedStatusEnum {
    LIKE(1, "点赞"),
    UNLIKE(0, "取消点赞/未点赞");
    private int code;
    private String message;

    LikedStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
