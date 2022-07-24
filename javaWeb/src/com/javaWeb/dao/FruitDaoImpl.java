package com.javaWeb.dao;

import com.javaWeb.pojo.Fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @Author wzc
 * @Date 2022/5/29
 */
public class FruitDaoImpl extends BaseDao<Fruit> implements FruitDao {

    @Override
    public int createFruit(Fruit fruit) {
        String sql = "insert into `fruit` (fname,price,fcount,remark) values (?,?,?,?)";
        return update(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
    }

    @Override
    public int deleteFruit(Fruit user) {
        String sql = "delete from `fruit` where id = ?";
        return update(sql, user.getId());
    }

    @Override
    public int updateFruit(Fruit fruit) {
        String sql = "update `fruit` set fname = ? , price = ? , fcount = ?,remark = ? where id = ?";
        return update(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getId());
    }

    @Override
    public Fruit getOneFruit(Fruit fruit) {
        String sql = "select * from `fruit` where id = ?";
        return getOne(sql, fruit.getId());
    }

    @Override
    public List<Fruit> getAllFruit() {
        String sql = "select * from `fruit`";
        return getList(sql);
    }

    @Override
    public List<Fruit> getFruitPage(Integer pageNo) {
        String sql = "select * from fruit limit ? , 5";
        return getList(sql, (pageNo - 1) * 5);
    }

    @Override
    public List<Fruit> getFruitBykey(String keyword, Integer pageNo) {
        String sql = "select * from fruit where fname like ? or remark like ? limit ? , 5";
        return getList(sql, "%" + keyword + "%", "%" + keyword + "%", (pageNo - 1) * 5);
    }

    @Override
    public Long getTotal() {
        String sql = "select count(*) from `fruit`";
        return GetValue(sql);
    }

    @Override
    public Long getTotalByKey(String keyword) {
        String sql = "select count(*) from `fruit` where fname like ? or remark like ? ";
        return GetValue(sql, "%" + keyword + "%", "%" + keyword + "%");
    }
}
