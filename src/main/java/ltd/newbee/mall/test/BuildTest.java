package ltd.newbee.mall.test;

import lombok.Data;


/**
 * @description:
 * @author: chenshutian
 * @create: 2020-05-26 20:21
 **/
@Data
public class BuildTest {
    String name;
    Integer age;
    String email;

    public BuildTest setName(String name) {
        this.name = name;
        return this;
    }

    public BuildTest setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BuildTest setEmail(String email) {
        this.email = email;
        return this;
    }

    public static BuildTest build() {
        return new BuildTest();
    }
}

class Test {
    public static void main(String ages[]) {
        BuildTest buildTest = BuildTest.build().setAge(1).setEmail("测试链式编程").setName("小明");
        System.out.println("buildTest.getAge() = " + buildTest.getAge());
    }
}

