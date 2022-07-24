package jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jdbc.bean.User;
import util.JDBCUtils;

/**
 * @Author wzc
 * @Date 2022/5/27
 */
public class jdbcTest {

    @Test
    public void queryTest() throws Exception {

        String sql = "select * from user where id = ?";
        User user = queryOne(sql, 4);
        System.out.println(user);
        String moreSql = "select * from user";
        List<User> users = queryMore(moreSql);
        System.out.println(users);
    }

    @Test
    public void insertTest() {
        String sql = "insert into `user` (name) values (?)";
        this.insertBatch(sql);
    }

    /**
     * 方式1,批量插入,10W数据,耗时629586
     * @param sql
     */
    private void insert(String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            long start = System.currentTimeMillis();
            // 连接
            connection = JDBCUtils.getConnection();
            // 预编译
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 100000; i++) {
                preparedStatement.setObject(1, "name" + i);
                preparedStatement.executeUpdate();
            }
            long end = System.currentTimeMillis();
            System.out.println("耗时" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, resultSet);
        }
    }

    /**
     * 方式2,
     * 批量插入batch,10W数据,
     *  未开启rewriteBatchedStatements,耗时629586;
     *  开启rewriteBatchedStatements,耗时3816
     *  开启rewriteBatchedStatements,关闭自动提交,耗时3312
     * @param sql
     */
    private void insertBatch(String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            long start = System.currentTimeMillis();
            // 连接
            connection = JDBCUtils.getConnection();
            // 关闭自动提交
            connection.setAutoCommit(false);
            // 预编译
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= 100000; i++) {
                preparedStatement.setObject(1, "name" + i);
                preparedStatement.addBatch();

                if (i % 500 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println("耗时" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, resultSet);
        }
    }

    private List<User> queryMore(String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 连接
            connection = JDBCUtils.getConnection();
            // 预编译
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                // 获取元数据
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    // 列别名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    // 列值
                    Object columnValue = resultSet.getObject(i + 1);
                    // 反射赋值
                    Field declaredField = User.class.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(user, columnValue);
                }
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, resultSet);
        }
        return null;
    }

    private User queryOne(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 连接
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            // 预编译填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                // 获取元数据
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    // 列别名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    // 列值
                    Object columnValue = resultSet.getObject(i + 1);
                    // 反射赋值
                    Field declaredField = User.class.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(user, columnValue);
                }
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
