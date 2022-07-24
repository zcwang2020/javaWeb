package com.javaWeb.servlet;


import com.javaWeb.dao.FruitDao;
import com.javaWeb.dao.FruitDaoImpl;
import com.javaWeb.myspringmvc.ViewBaseServlet;
import com.javaWeb.pojo.Fruit;
import org.apache.commons.lang.StringUtils;
import util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/fruit.do")
public class FruitServlet extends ViewBaseServlet {
    private FruitDao fruitDAO = new FruitDaoImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");

        String operate = request.getParameter("operate");
        if(StringUtils.isEmpty(operate)){
            operate = "index" ;
        }

        switch(operate){
            case "index":
                index(request,response);
                break;
            case "add":
                add(request,response);
                break;
            case "del":
                del(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
            case "update":
                update(request,response);
                break;
            default:
                throw new RuntimeException("operate值非法!");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FruitDao fruitDAO = new FruitDaoImpl();
        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            //1.设置编码
            request.setCharacterEncoding("utf-8");

            //2.获取参数
            String idStr = request.getParameter("id");
            Long id = Long.parseLong(idStr);
            String fname = request.getParameter("fname");
            String priceStr = request.getParameter("price");
            int price = Integer.parseInt(priceStr);
            String fcountStr = request.getParameter("fcount");
            Integer fcount = Integer.parseInt(fcountStr);
            String remark = request.getParameter("remark");

            //3.执行更新
            fruitDAO.updateFruit(new Fruit(id, fname, price, fcount, remark));

            //4.资源跳转
            //super.processTemplate("index",request,response);
            //request.getRequestDispatcher("index01.html").forward(request,response);
            //此处需要重定向，目的是重新给IndexServlet发请求，重新获取furitList，然后覆盖到session中，这样index.html页面上显示的session中的数据才是最新的
            response.sendRedirect("fruit.do");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }
    }

    private void edit(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            String idStr = request.getParameter("id");
            if(StringUtils.isNotEmpty(idStr)){
                long fid = Long.parseLong(idStr);
                Fruit fruit = new Fruit();
                fruit.setId(fid);
                Fruit fruitFromDB = fruitDAO.getOneFruit(fruit);
                request.setAttribute("fruit",fruitFromDB);
                super.processTemplate("edit",request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }
    }

    private void del(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            String idStr = request.getParameter("id");
            if (StringUtils.isNotBlank(idStr)) {
                Long id = Long.parseLong(idStr);
                Fruit fruit = new Fruit();
                fruit.setId(id);
                fruitDAO.deleteFruit(fruit);

                //super.processTemplate("index",request,response);
                response.sendRedirect("fruit.do");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("fname");
        String price = request.getParameter("price");
        int intPrice = Integer.parseInt(price);
        String fcount = request.getParameter("fcount");
        int intCount = Integer.parseInt(fcount);
        String remark = request.getParameter("remark");

        Fruit fruit = new Fruit();
        fruit.setFname(fname);
        fruit.setPrice(intPrice);
        fruit.setFcount(intCount);
        fruit.setRemark(remark);

        FruitDaoImpl fruitDao = new FruitDaoImpl();

        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            int row = fruitDao.createFruit(fruit);
            System.out.println(row == 1 ? "插入成功" : "插入失败");
            response.sendRedirect("fruit.do");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }

    }

    private void index(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            HttpSession session = request.getSession() ;
            Integer pageNo = 1 ;

            String oper = request.getParameter("oper");
            //如果oper!=null 说明 通过表单的查询按钮点击过来的
            //如果oper是空的，说明 不是通过表单的查询按钮点击过来的

            String keyword = null ;
            if(StringUtils.isNotEmpty(oper) && "search".equals(oper)){
                //说明是点击表单查询发送过来的请求
                //此时，pageNo应该还原为1 ， keyword应该从请求参数中获取
                pageNo = 1 ;
                keyword = request.getParameter("keyword");
                if(StringUtils.isEmpty(keyword)){
                    keyword = "" ;
                }
                session.setAttribute("keyword",keyword);
            }else{
                //说明此处不是点击表单查询发送过来的请求（比如点击下面的上一页下一页或者直接在地址栏输入网址）
                //此时keyword应该从session作用域获取
                String pageNoStr = request.getParameter("pageNo");
                if(StringUtils.isNotEmpty(pageNoStr)){
                    pageNo = Integer.parseInt(pageNoStr);
                }
                Object keywordObj = session.getAttribute("keyword");
                if(keywordObj!=null){
                    keyword = (String)keywordObj ;
                }else{
                    keyword = "" ;
                }
            }
            session.setAttribute("pageNo", pageNo);
            FruitDao fruitDAO = new FruitDaoImpl();
            List<Fruit> fruitList = fruitDAO.getFruitBykey(keyword, pageNo);
            //保存到session作用域
            session.setAttribute("fruitList", fruitList);
            connection = JDBCUtils.getDruidConnection();
            //总记录条数
            Long fruitCount = fruitDAO.getTotalByKey(keyword);
            //总页数
            long pageCount = (fruitCount + 5 - 1) / 5;
        /*
        总记录条数       总页数
        1               1
        5               1
        6               2
        10              2
        11              3
        fruitCount      (fruitCount+5-1)/5
         */
            session.setAttribute("pageCount", pageCount);
            //此处的视图名称是 index
            //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
            //逻辑视图名称 ：   index
            //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
            //所以真实的视图名称是：      /       index       .html
            super.processTemplate("index", request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }

    }
}
