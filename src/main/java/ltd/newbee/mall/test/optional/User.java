package ltd.newbee.mall.test.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-12-19 10:31
 **/
@Data
public class User {
    private Integer id;
    private Integer age;
    private String name;

    private User(Integer id , Integer age , String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    private User() {

    }



    public static User getUser(int i ) {
        if (i == 1) {

            return new User(1, 2, "c");
        }
        else {
            return null;
        }
    }

}