package com.javaWeb.dao;

import com.javaWeb.pojo.Fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @Author wzc
 * @Date 2022/5/29
 */
public interface FruitDao {

    /**
     * 创建fruit
     * @param fruit
     */
    int createFruit(Fruit fruit);

    /**
     * 删除用户
     * @param fruit
     */
    int deleteFruit(Fruit fruit);

    /**
     * 更新用户
     * @param fruit
     */
    int updateFruit(Fruit fruit);

    /**
     * 查询单个用户
     * @param fruit
     * @return
     */
    Fruit getOneFruit(Fruit fruit);

    /**
     * 批量查询用户
     * @return
     */
    List<Fruit> getAllFruit();

    /**
     * 分页查询
     * @param pageNo
     * @return
     */
    List<Fruit> getFruitPage(Integer pageNo);

    /**
     * 关键字查询
     * @param keyword
     * @param pageNo
     * @return
     */
    List<Fruit> getFruitBykey(String keyword, Integer pageNo);

    /**
     * 查询用户总数
     * @return
     */
    Long getTotal();

    /**
     * 关键字查询总数
     * @param keyword
     * @return
     */
    Long getTotalByKey(String keyword);
}
