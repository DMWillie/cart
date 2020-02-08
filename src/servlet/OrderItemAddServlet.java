package servlet;
/*  Author: 北辰
    日期: 05/02/2020
    功能: 购买商品
    购买行为本身就是创建一个OrderItem对象
    在负责购买商品的OrderItemAddServlet中,进行如下流程:
    1.获取购买数量
    2.获取购买商品的id
    3.根据id获取商品对象
    4.创建一个新的OrderItem对象
    5.从session中取出一个List,这个List里面存放陆续购买的商品
        如果是第一次从session中获取这个List,那么它会是空的,需要创建一个ArrayList
    6.把新创建的OrderItem对象放入该List中
    7.跳转到显示购物车的listOrderItem
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.Product;
import bean.OrderItem;
import dao.ProductDAO;

public class OrderItemAddServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取购买数量
        int num = Integer.parseInt(request.getParameter("num"));
        //获取商品pid
        int pid = Integer.parseInt(request.getParameter("pid"));
        //根据id获取商品
        Product p = new ProductDAO().getProduct(pid);

        OrderItem oi = new OrderItem();
        oi.setNum(num);
        oi.setProduct(p);

        List<OrderItem> list = (List<OrderItem>)request.getSession().getAttribute("ois");
        if(null==list){     //第一次获取为空
            //创建一个新的ArrayList
            list = new ArrayList<OrderItem>();
            //设置session的属性ois为这个list
            request.getSession().setAttribute("ois",list);
        }
        /**在把该物品加入到list之前要判断是否有同样的商品
         * 遍历session中所有的OrderItem,如果找到对应的product.id一样的条目,就调整其数量
         * 如果没有找到,就新增加一条*/
        boolean found = false;
        for(Iterator<OrderItem> it=list.iterator();it.hasNext();){
            OrderItem tempOI = it.next();
            if(tempOI.getProduct().getId()==oi.getProduct().getId()){
                //找到相同的ProductId
                tempOI.setNum(tempOI.getNum()+oi.getNum());
                found = true;
                break;
            }
        }
        if(!found)          //未找到同样的商品则新增加一条
            list.add(oi);
        //重定向到listOrderItem页
        response.sendRedirect("/listOrderItem");
    }
}
