package domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-03-15 18:11
 **/
@Data
public class Days implements Serializable {

    private String openId;
    private String daysId;
    //每天的标题
    private String title;
    //代办事项的数量
    private int itemNumber;
    //日程
    private String date;

}

