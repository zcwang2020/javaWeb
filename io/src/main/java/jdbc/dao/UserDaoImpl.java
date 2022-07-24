package jdbc.dao;

import java.sql.Connection;
import java.util.List;

import jdbc.bean.User;

/**
 * @Author wzc
 * @Date 2022/5/29
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public int createUser(User user) {
        String sql = "insert into `user` (name,age) values (?,?)";
        return update(sql, user.getName(), user.getAge());
    }

    @Override
    public int deleteUser(User user) {
        String sql = "delete from `user` where id = ?";
        return update(sql, user.getId());
    }

    @Override
    public int updateUser(User user) {
        String sql = "update `user` set name = ? , age = ? where id = ?";
        return update(sql, user.getName(), user.getAge(), user.getId());
    }

    @Override
    public User getOneUser(User user) {
        String sql = "select * from `user` where id = ?";
        return getOne(sql, user.getId());
    }

    @Override
    public List<User> getAllUser() {
        String sql = "select * from `user`";
        return getList(sql);
    }

    @Override
    public Long getTotal() {
        String sql = "select count(*) from `user`";
        return GetValue(sql);
    }
}
