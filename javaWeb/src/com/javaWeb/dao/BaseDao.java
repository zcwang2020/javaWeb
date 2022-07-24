package com.javaWeb.dao;

import util.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wzc
 * @Date 2022/5/29
 */
public abstract class BaseDao<T> {

    private Class<T> clazz = null;

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        clazz = (Class<T>) actualTypeArguments[0];
    }

    public int update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // 预编译sql
        try {
            connection = JDBCUtils.getDruidConnection();
            preparedStatement = connection.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            return preparedStatement.executeUpdate();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
        return 0;
    }

    public T getOne(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            // 预编译sql
            preparedStatement = connection.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(1, args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            // 获取结果集元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 总列数
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = resultSet.getObject(i + 1);
                    // 获取列名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field declaredField = t.getClass().getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
        return null;
    }

    public List<T> getList(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            // 预编译sql
            preparedStatement = connection.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            // 获取结果集元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 总列数
            int columnCount = metaData.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while (resultSet.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = resultSet.getObject(i + 1);
                    // 获取列名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field declaredField = t.getClass().getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, resultSet);
        }
        return null;
    }

    public <E> E GetValue(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            // 预编译sql
            preparedStatement = connection.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // 只有一行数据,例如count(*)
                return (E) resultSet.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
