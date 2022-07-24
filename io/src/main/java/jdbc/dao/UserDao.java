package jdbc.dao;

import jdbc.bean.User;

import java.sql.Connection;
import java.util.List;

/**
 * @Author wzc
 * @Date 2022/5/29
 */
public interface UserDao {

    /**
     * 创建user
     * @param user
     */
    int createUser(User user);

    /**
     * 删除用户
     * @param user
     */
    int deleteUser(User user);

    /**
     * 更新用户
     * @param user
     */
    int updateUser(User user);

    /**
     * 查询单个用户
     * @param user
     * @return
     */
    User getOneUser(User user);

    /**
     * 批量查询用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户总数
     * @return
     */
    Long getTotal();
}
