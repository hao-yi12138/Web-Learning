package ServletPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description:比较用户登录信息
 * @author: HAOYI
 * @date:2020-11-03 14:49
 **/
public class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 提前准备一些系统中的用户
    private static final List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("xiaoyi", "123"));
        userList.add(new User("xiaoer", "456"));
    }

    public static User login(String username, String password) {
        // 本质上就是一个查找
        for (User user : userList) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return user;
            }
        }

        return null;
    }
}
