package com.javaWeb.test;

import com.javaWeb.dao.FruitDaoImpl;
import com.javaWeb.pojo.Fruit;
import org.junit.Test;
import util.JDBCUtils;

import java.sql.Connection;

/**
 * @Author wzc
 * @Date 2022/6/5
 */
public class FruitTest {

    FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Test
    public void getOneFruit() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            Fruit fruit = new Fruit();
            fruit.setId(1L);
            System.out.println(fruitDao.getOneFruit(fruit));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }
    }

    @Test
    public void getFruitByKey() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            String key = "测试";
            System.out.println(fruitDao.getFruitBykey(key, 1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }
    }

    @Test
    public void getFruitPage() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            Integer pagrNo = 1;
            System.out.println(fruitDao.getFruitPage(pagrNo));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }
    }



}
