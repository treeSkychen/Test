package ltd.newbee.mall.test.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-05-29 10:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String name;
    private int age;
    private String address;

}

class TestB {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new FileOutputStream("C:\\Users\\single\\Desktop\\ojb.txt")
        );
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        out.writeInt(s1.getAge());
        out.writeUTF(s1.getName());
        out.writeUTF(s1.getAddress());
        out.close();

        DataInputStream in = new DataInputStream(
                new FileInputStream("C:\\Users\\single\\Desktop\\ojb.txt")
        );
        Student student = new Student();
        student.setName(in.readUTF());

        student.setAge(in.readInt());
        System.out.println("student = " + student);
    }
}

class TestA {

    public static void main(String[] args) {
        Student s1 = new Student(1L, "肖战", 15, "浙江");

        Student s2 = new Student(2L, "王一博", 15, "湖北");

        Student s3 = new Student(3L, "杨紫", 17, "北京");

        Student s4 = new Student(4L, "李现", 17, "浙江");

        Student s5 = new Student(1L, "肖战", 15, "浙江");
    }

}

