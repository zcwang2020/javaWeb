/**
 * @(#)DBCPTest.java, 2022/5/30.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package jdbc.dataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import jdbc.ConnectionTest;

/**
 * @Author zcwang
 * @Date 2022/5/30
 */
public class DBCPTest {

    @Test
    public void testDBCP() throws SQLException {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql:///dev");
        source.setUsername("root");
        source.setPassword("abc123");
        System.out.println(source);
        System.out.println(source.getConnection());
    }

    @Test
    public void testDBCPConfig() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        Properties pros = new Properties();
        pros.load(is);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(pros);
        System.out.println(dataSource.getConnection());
    }
}