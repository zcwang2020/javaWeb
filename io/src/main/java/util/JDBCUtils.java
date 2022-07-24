package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

/**
 * @Author wzc
 * @Date 2022/5/27
 */
public class JDBCUtils {

    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloC3P0");

    private static DataSource dataSource;

    private static DataSource druidDataSource;

    static {
        InputStream is = null;
        try {
            is = JDBCUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
            Properties pros = new Properties();
            pros.load(is);
            dataSource = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        InputStream is = null;
        try {
            is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties pros = new Properties();
            pros.load(is);
            druidDataSource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static Connection getConnection() throws Exception {
        InputStream rs = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(rs);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");
        Class.forName(driverClass);
        return DriverManager.getConnection(url, user, password);
    }

    public static Connection getC3P0Connection() throws Exception {
        return cpds.getConnection();
    }

    public static Connection getDBCPConnection() throws Exception {
        return dataSource.getConnection();
    }

    public static Connection getDruidConnection() throws Exception {
        return druidDataSource.getConnection();
    }



    public static void closeConnection(Connection connection, PreparedStatement preparedStatement,
        ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        try {
            if (preparedStatement != null) {

                preparedStatement.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        try {
            if (resultSet != null) {

                resultSet.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public static void DBUtilsClose(Connection connection, PreparedStatement preparedStatement,
        ResultSet resultSet) {
        DbUtils.closeQuietly(connection,preparedStatement, resultSet);
    }
}
