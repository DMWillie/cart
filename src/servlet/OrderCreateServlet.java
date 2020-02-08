package servlet;
/*  Author: 北辰
    日期: 05/02/2020
    功能: OrderCreateServlet创建订单的Servlet
1. 首先判断用户是否登陆，如果没有登陆跳转到登陆页面
2. 创建一个订单对象，并设置其所属用户
3. 把该订单对象保存到数据库中
4. 遍历session中所有的订单项，设置他们的Order。 然后保存到数据库中
5. 清空session中的订单项
6. 最后打印订单创建成功
 */

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDAO;
import dao.OrderItemDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderCreateServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User u = (User)request.getSession().getAttribute("user");
        if(null==u){
            response.sendRedirect("/login.jsp");
            return;
        }
        Order o = new Order();
        o.setUser(u);
        //将订单插入到数据库中
        new OrderDAO().insert(o);

        List<OrderItem> list= (List<OrderItem>)request.getSession().getAttribute("ois");
        for(OrderItem orderItem:list){
            orderItem.setOrder(o);
            new OrderItemDAO().insert(orderItem);
        }
        //清空session
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("订单创建成功");
    }
}
