package servlet;
/*  Author: 北辰
    日期: 05/02/2020
    功能: OrderItemListServlet显示购物车
    OrderItemListServlet其实什么也不用做,因为数据已经在session中准备好了,直接服务端跳转到listOrderItem.jsp
    在listOrderItem.jsp中，从session中遍历出所有的OrderItem
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderItemListServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("listOrderItem.jsp").forward(request,response);
    }
}
