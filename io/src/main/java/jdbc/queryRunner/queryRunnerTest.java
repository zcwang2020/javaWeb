/**
 * @(#)queryRunnerTest.java, 2022/5/30.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package jdbc.queryRunner;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import jdbc.bean.User;
import util.JDBCUtils;

/**
 * @Author zcwang
 * @Date 2022/5/30
 */
public class queryRunnerTest {

    @Test
    public void testInsert() {
        Connection coon = null;
        try {
            QueryRunner runner = new QueryRunner();
            coon = JDBCUtils.getDruidConnection();
            String sql = "update `user` set name = 'feature' where id = ?";
            System.out.println("影响行数" + runner.update(coon, sql, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(coon, null, null);
            System.out.println(coon);
        }
    }

    @Test
    public void testQueryOne() {
        Connection coon = null;
        try {
            QueryRunner runner = new QueryRunner();
            coon = JDBCUtils.getDruidConnection();
            String sql = "select * from `user` where id = ?";
            BeanHandler<User> handler = new BeanHandler<>(User.class);
            User user = runner.query(coon, sql, handler, 3);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(coon, null, null);
            System.out.println(coon);
        }
    }

    @Test
    public void testQueryMore() {
        Connection coon = null;
        try {
            QueryRunner runner = new QueryRunner();
            coon = JDBCUtils.getDruidConnection();
            String sql = "select * from `user` where id > ?";
            BeanListHandler<User> handler = new BeanListHandler<>(User.class);
            List<User> userList = runner.query(coon, sql, handler, 2);
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(coon, null, null);
            System.out.println(coon);
        }
    }

    @Test
    public void testScalar() {
        Connection coon = null;
        try {
            QueryRunner runner = new QueryRunner();
            coon = JDBCUtils.getDruidConnection();
            String sql = "select count(*) from `user`";
            ScalarHandler scalarHandler = new ScalarHandler();
            Long query = (Long) runner.query(coon, sql, scalarHandler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(coon, null, null);
            System.out.println(coon);
        }
    }
}