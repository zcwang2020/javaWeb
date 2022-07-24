package com.javaWeb.controllers;


import com.javaWeb.dao.FruitDao;
import com.javaWeb.dao.FruitDaoImpl;
import com.javaWeb.pojo.Fruit;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author wzc
 */
public class FruitController {
    private final FruitDao fruitDAO = new FruitDaoImpl();

    private String update(Long id, String fname, Integer price, Integer fcount, String remark) {
        //3.执行更新
        fruitDAO.updateFruit(new Fruit(id, fname, price, fcount, remark));
        //4.资源跳转
        return "redirect:fruit.do";
    }

    private String edit(Long id, HttpServletRequest request) {
        if (id != null) {
            Fruit fruit = new Fruit();
            fruit.setId(id);
            Fruit oneFruit = fruitDAO.getOneFruit(fruit);
            request.setAttribute("fruit", oneFruit);
            //super.processTemplate("edit",request,response);
            return "edit";
        }
        return "error";
    }

    private String del(Long id) {
        if (id != null) {
            Fruit fruit = new Fruit();
            fruit.setId(id);
            fruitDAO.deleteFruit(fruit);
            return "redirect:fruit.do";
        }
        return "error";
    }

    private String add(String fname, Integer price, Integer fcount, String remark) {
        Fruit fruit = new Fruit(null, fname, price, fcount, remark);
        fruitDAO.createFruit(fruit);
        return "redirect:fruit.do";
    }

    private String index(String oper, String keyword, Integer pageNo, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (pageNo == null) {
            pageNo = 1;
        }
        if (StringUtils.isNotEmpty(oper) && "search".equals(oper)) {
            pageNo = 1;
            if (StringUtils.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                keyword = (String) keywordObj;
            } else {
                keyword = "";
            }
        }

        // 重新更新当前页的值
        session.setAttribute("pageNo", pageNo);

        FruitDao fruitDAO = new FruitDaoImpl();
        List<Fruit> fruitList = fruitDAO.getFruitBykey(keyword, pageNo);
        session.setAttribute("fruitList", fruitList);

        //总记录条数
        long fruitCount = fruitDAO.getTotalByKey(keyword);
        //总页数
        int pageCount = (int) ((fruitCount + 5 - 1) / 5);
        session.setAttribute("pageCount", pageCount);

        return "index";
    }
}
