/**
 * @(#)druidTest.java, 2022/5/30.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package jdbc.dataSource;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * @Author zcwang
 * @Date 2022/5/30
 */
public class druidTest {

    @Test
    public void testDruid() {
        try {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            Properties pros = new Properties();
            pros.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);
            System.out.println(dataSource);
            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}