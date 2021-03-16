package ltd.newbee.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

/**
 * @program: newbee-mall
 * @description: 点赞记录表
 * @author: chenshutian
 * @create: 2021-03-16 11:03
 **/
@Data
@Builder
public class ThumbLog {
    @TableId
    private Integer id;
    private Integer aid;    //文章id
    private Integer uid;    //用户id
}
