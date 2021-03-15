package ltd.newbee.mall.test.optional;

import java.util.Optional;

/**
 * @description:
 * @author: chenshutian
 * @create: 2020-12-19 10:33
 **/
public class Test1 {
    public static void main(String[] args) {

        User user = User.getUser(1);
        Optional.ofNullable(user).ifPresent(user1 -> System.out.println(user1));
//        Optional.of(user);
//        Optional.empty();
        System.out.println(Optional.ofNullable(user));
        Optional<User> user1 = Optional.ofNullable(user);
        if (user1.isPresent()) System.out.println(user1.get());
        System.out.println(user1.orElse(User.getUser(2)));
        Optional.ofNullable(user).orElseThrow(RuntimeException::new);
        System.out.println(user1.map(User::getName).map(String::toUpperCase).orElse(null));
        System.out.println(user1.map(User::getId).get());


    }

    public User get(User user) {
        return Optional.of(user).get();
    }

}