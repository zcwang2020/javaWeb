package jdbc.dataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author wzc
 * @Date 2022/5/29
 */
public class C3P0Test {

    @Test
    public void testC3P0() throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/mysql80?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        cpds.setUser("root");
        cpds.setPassword("abc123");
        cpds.setInitialPoolSize(10);
        System.out.println(cpds);
    }

    @Test
    public void testC3P0Config() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloC3P0");
        Connection connection = cpds.getConnection();
        System.out.println(connection);
    }

}
