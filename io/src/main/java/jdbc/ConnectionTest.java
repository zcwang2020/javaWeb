/**
 * @(#)ConnectionTest.java, 2022/5/27.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

/**
 * @Author zcwang
 * @Date 2022/5/27
 */
public class ConnectionTest {

    @Test
    public void testConnection1() throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/dev";

        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "abc123");

        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }

    @Test
    public void testConnection2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        String url = "jdbc:mysql://localhost:3306/dev";

        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "abc123");

        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }

    /**
     * 使用DriverManager替换Driver
     */
    @Test
    public void testConnection3() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String url = "jdbc:mysql://localhost:3306/dev";
        String user = "root";
        String password = "abc123";

        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void testConnection4() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/dev";
        String user = "root";
        String password = "abc123";

        // 加载mysql驱动，随着类的加载，自动注册
        Class.forName("com.mysql.jdbc.Driver");
        /**
         * 在Driver实现类中，声明了如下操作
         * static {
         *         try {
         *             DriverManager.registerDriver(new Driver());
         *         } catch (SQLException var1) {
         *             throw new RuntimeException("Can't register driver!");
         *         }
         *     }
         */

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    /**
     * 最终版
     * 配置化
     */
    @Test
    public void getConnection() throws IOException, ClassNotFoundException {
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driver = pros.getProperty("driverClass");

        Class.forName(driver);

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}