package ltd.newbee.mall.entity.dto;

import lombok.Data;

/**
 * @program: newbee-mall
 * @description:
 * @author: chenshutian
 * @create: 2021-03-15 20:04
 **/
@Data
public class LikedCountDTO {

    private String key;
    private Integer value;

    public LikedCountDTO(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public LikedCountDTO() {

    }

}
