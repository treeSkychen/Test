package ltd.newbee.mall.entity;

import lombok.Data;

/**
 * @program: newbee-mall
 * @description: 文章内容
 * @author: chenshutian
 * @create: 2021-03-16 10:59
 **/
@Data
public class Article {

    private Integer articleId; //主键id
    private String content;    //文章内容

}
