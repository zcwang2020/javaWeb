package jdbc;

import jdbc.bean.User;
import jdbc.dao.UserDaoImpl;
import org.junit.Test;

import java.util.List;

/**
 * @Author wzc
 * @Date 2022/5/29
 */
public class UserDaoImplTest {

    private final UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void createUser() {
        User user = new User(1L, "小明", 3);
        int row = userDao.createUser(user);
        System.out.println(row == 1 ? "插入成功" : "插入失败");
    }

    @Test
    public void deleteUser() {
        User user = new User();
        user.setId(1L);
        int row = userDao.deleteUser(user);
        System.out.println(row == 1 ? "删除成功" : "删除失败");
    }

    @Test
    public void updateUser() {
        User user = new User(3L, "流", 5);
        int row = userDao.updateUser(user);
        System.out.println(row == 1 ? "更新成功" : "更新失败");
    }

    @Test
    public void getOneUser() {
        User user = new User();
        user.setId(3L);
        System.out.println(userDao.getOneUser(user));
    }

    @Test
    public void getAllUser() {
        List<User> allUser = userDao.getAllUser();
        allUser.forEach(System.out::println);
    }

    @Test
    public void getTotal() {
        System.out.println(userDao.getTotal());
    }
}
